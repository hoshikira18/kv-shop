/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.accounts;

import com.sun.net.httpserver.HttpServer;
import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Log;
import models.User;
import models.UserDAO;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/accounts/create"})
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String name = (String) req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = (String) req.getParameter("phone");
        String address = (String) req.getParameter("address");
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");

//        out.print(name);
        UserController uc = new UserController();
        int adminRoleID = 1;
        User user = new User(name, age, phone, address, email, password, adminRoleID);
        int u = uc.createUser(user);

        out.print(u);

        req.setAttribute("status", false);

        if (u == 300) {
            req.setAttribute("status", false);
            Log log = new Log(this.getClass().getName(), req, false, user);
            req.setAttribute("message", "Failed! Try to use another phone number!");
        } else {
            req.setAttribute("status", true);
            Log log = new Log(this.getClass().getName(), req, true, user);
            req.setAttribute("message", "Successfuly!");
        }

        List<User> adminUsers = new UserDAO().getAllAdmins();

        req.setAttribute("adminUsers", adminUsers);

        req.getRequestDispatcher("/admin/accounts.jsp").forward(req, resp);
    }

}
