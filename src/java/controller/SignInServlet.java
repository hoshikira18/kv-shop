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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import models.Log;
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

        //tạo file log ghi nhật kí của system
        String datetime = LocalDateTime.now().toString().split("[.]")[0];
        String date = "";
        String[] listPart = datetime.split("[:]");
        for (int i = 0; i < listPart.length - 1; i++) {
            date += listPart[i] + "-";
        }
        date += listPart[listPart.length - 1];
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("runningSession", date);
        //get user infor
        String phone = req.getParameter("phone");
        String pw = req.getParameter("password");

        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);

        if (u.getPassword().equals(pw)) {
            // Tao session

            httpSession.setAttribute("phone", u.getPhoneNumber());
            httpSession.setAttribute("role", u.getRoleID());

            // gọi log
            Log log = new Log(this.getClass().getName(), phone, pw, date, true);
            if (u.getRoleID() == 1) {
                resp.sendRedirect("/shop/admin/products");
            } else {
                ProductDAO pd = new ProductDAO();
                List<Product> list = pd.getTop(8);
                req.setAttribute("list", list);
                req.getRequestDispatcher("/home").forward(req, resp);
//                resp.sendRedirect("/shop/");
            }
        } else {
            Log log = new Log(this.getClass().getName(), phone, pw, date, false);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

}
