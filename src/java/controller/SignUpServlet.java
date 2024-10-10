/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.User;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserController ud = new UserController();
        int customerRoleID = 2;
        int u = ud.createUser(new User(name, age, phone, address, email, password, customerRoleID));

        req.setAttribute("status", false);

        if (u == 300) {
            req.setAttribute("status", false);
            req.setAttribute("message", "Failed! Try to use another phone number!");

        } else {
            req.setAttribute("status", true);
            req.setAttribute("message", "Successfuly!");
        }

        req.getRequestDispatcher("signup.jsp").forward(req, resp);

    }

}
