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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import models.User;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String pw = req.getParameter("password");

        UserController ud = new UserController();
        User u = ud.getUserByPhone(phone);

        if (u.getPassword().equals(pw)) {
            // Tao session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("phone", u.getPhoneNumber());
            httpSession.setAttribute("role", u.getRoleID());
            
            if (u.getRoleID() == 1) {
                resp.sendRedirect("/shop/admin/products.jsp");
            } else {
                resp.sendRedirect("/shop/");
            }
        }

    }

}
