/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.orders;

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

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = "/admin/view-orders/*")
public class ViewServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String pathInfor = req.getPathInfo();
        Log log = new Log(this.getClass().getName(), req);
        String orderID = pathInfor.split("/")[1];
        OrderDAO od = new OrderDAO();
        String[] order = od.getRelatedInfor(Integer.parseInt(orderID));
        
        req.setAttribute("order", order);
        req.getRequestDispatcher("/admin/orders/view.jsp").forward(req, resp);
        
    }
    
}
