/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Log;
import models.Order;
import models.OrderDAO;
import models.User;
import models.UserDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/editAccount"})
public class EditAccountservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String phone = (String) req.getSession().getAttribute("phone");
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        out.println("doPost");
        ////update here
        String from = req.getParameter("from");
        if (from.equals("profile")) {
            String userName = req.getParameter("userName");
            u.setUserName(userName);
            Log log = new Log(this.getClass().getName(), req, from, userName);
            ud.update(u);
        }else if(from.equals("password")){
            String password = req.getParameter("newPassword");
            u.setPassword(password);
            Log log = new Log(this.getClass().getName(), req, from, password);
            ud.update(u);
        }else if(from.equals("address")){
            String address = req.getParameter("address");
            u.setAddress(address);
            Log log = new Log(this.getClass().getName(), req, from, address);
            ud.update(u);
        }
        
        out.println("Update Done!");
        String xSql = "update Users " + u.forUpdate() + " where userID = " + u.getUserID();
        out.println(xSql);
        ////get infor from here
        OrderDAO od = new OrderDAO();
        List<Order> listOrders = od.getOrdersByUser(u.getUserID());
//        for (Order listOrder : listOrders) {
//            out.println("Order: "+listOrder.getOrderID()+" userID: "+listOrder.getOrderID());
//        }
//        Order o = new Order();
//        o.getOrderID();
//        o.getCreate_at();
        //// setAttribute from here
        req.setAttribute("oldPassword", u.getPassword());
        req.setAttribute("orders", listOrders);
        req.setAttribute("user", u);
        req.getRequestDispatcher("myAccount.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String phone = (String) req.getSession().getAttribute("phone");
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        out.println("doGet");
        out.println("UserID: " + u.getUserID());
        ////get infor from here
        OrderDAO od = new OrderDAO();
        List<Order> listOrders = od.getOrdersByUser(u.getUserID());
//        for (Order listOrder : listOrders) {
//            out.println("Order: "+listOrder.getOrderID()+" userID: "+listOrder.getOrderID());
//        }
//        Order o = new Order();
//        o.getOrderID();
//        o.getCreate_at();
        //// setAttribute from here
        req.setAttribute("oldPassword", u.getPassword());
        req.setAttribute("orders", listOrders);
        req.setAttribute("user", u);
        req.getRequestDispatcher("myAccount.jsp").forward(req, resp);
    }

}
