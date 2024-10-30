package controller.admin.accounts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import models.Log;
import models.User;
import models.UserDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/edit-account/*"})
@MultipartConfig
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();

        // lay ra san pham bang id
        int id = Integer.parseInt(pathInfo.split("/")[1]);

        request.setAttribute("id", id);

        out.print(id);

        User u = new UserDAO().getOne(id);
        Log log = new Log(this.getClass().getName(), request, true, u);

        request.setAttribute("user", u);

        request.getRequestDispatcher("/admin/accounts/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();

        // lay ra san pham bang id
        int id = Integer.parseInt(pathInfo.split("/")[1]);

        request.setAttribute("id", id);

//        out.print(id);
        UserDAO ud = new UserDAO();

        User u = ud.getOne(id);
        u.setUserName((String) request.getParameter("name"));
        u.setAge((Integer.parseInt(request.getParameter("age"))));
        u.setAddress((String) request.getParameter("address"));
        u.setEmail((String) request.getParameter("email"));
        u.setPassword((String) request.getParameter("password"));
        u.setPhoneNumber((String) request.getParameter("phone"));
        ud.update(u);
        out.print(u.getAge());
        out.print(u.getUserName());

        out.print(u.getEmail());

        out.print(u.getPassword());

        out.print(u.getPhoneNumber());
        out.print(u.getRoleID());
        out.print(u.getUserID());
        Log log = new Log(this.getClass().getName(), request, true, u);

        List<User> adminUsers = ud.getAllAdmins();

        request.setAttribute("adminUsers", adminUsers);

        request.getRequestDispatcher("/admin/accounts.jsp").forward(request, response);
    }

}
