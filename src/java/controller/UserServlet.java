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
import java.util.List;
import models.Log;
import models.Product;
import models.ProductDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/user"})
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO pd = new ProductDAO();
        
        Log log = new Log(this.getClass().getName(), req);
        
        List<Product> list = pd.getTop(8, "desc");
        
        req.setAttribute("list", list);
        req.getRequestDispatcher("/").forward(req, resp);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
