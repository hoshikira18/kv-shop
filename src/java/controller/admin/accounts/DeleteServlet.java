/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.accounts;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.Log;
import models.User;
import models.UserDAO;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/delete-account"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("user-id"));
        User u = new UserDAO().getOne(id);
        Log log = new Log(this.getClass().getName(), req, true, u);
        new UserDAO().delete(id);
        resp.sendRedirect("/shop/admin/accounts");
    }

}
