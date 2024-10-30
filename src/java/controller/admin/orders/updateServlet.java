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
import models.Log;
import models.OrderDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/admin/update-order/*"})
public class updateServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Log log = new Log(this.getClass().getName(), req);
        
        String orderID = req.getParameter("orderID");
        String status = req.getParameter("status");
        
        OrderDAO od = new OrderDAO();
        od.updateStatus(Integer.parseInt(orderID), status);
        String[] order = od.getRelatedInfor(Integer.parseInt(orderID));
        
        req.setAttribute("order", order);
        req.getRequestDispatcher("/admin/orders/view.jsp").forward(req, resp);
    }
    
}
