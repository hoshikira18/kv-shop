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
import java.util.List;
import models.Product;
import models.ProductDAO;
import models.User;
import models.UserDAO;

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

//        UserController ud = new UserController();
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);

        if (u.getPassword().equals(pw)) {
            // Tao session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("phone", u.getPhoneNumber());
            httpSession.setAttribute("role", u.getRoleID());

            if (u.getRoleID() == 1) {
                resp.sendRedirect("/shop/admin/products.jsp");
            } else {
                ProductDAO pd = new ProductDAO();
                List<Product> list = pd.getTop(8);
//                int i = 0;
//                for (Product product : list) {
//                    if (i % 2 == 0) {
//                        product.setImage("https://images.unsplash.com/photo-1508423134147-addf71308178?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&h=400&q=80");
//                    } else {
//                        product.setImage("https://images.unsplash.com/photo-1555982105-d25af4182e4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&h=400&q=80");
//                    }
//                    i++;
//                }
                req.setAttribute("list", list);
                req.getRequestDispatcher("/").forward(req, resp);
//                resp.sendRedirect("/shop/");
            }
        }

    }

}
