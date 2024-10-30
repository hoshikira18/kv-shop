/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.orders;

import controller.ProductsController;
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
import models.Product;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/admin/orders"})
public class ListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log(this.getClass().getName(), req);
        PrintWriter out = resp.getWriter();
        OrderDAO od = new OrderDAO();
        // ps = products
        List<Order> ps = od.getAllOrders(false);
        out.print(ps.size());
        req.setAttribute("ps", ps);
        req.getRequestDispatcher("/admin/orders.jsp").forward(req, resp);
        
    }
    
}
