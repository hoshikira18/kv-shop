package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.Product;
import models.ProductDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/products/*"})
public class ProductDetail extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
       
        PrintWriter out = response.getWriter();
        
        String pathInfo = request.getPathInfo();
        
        out.print(pathInfo);
        
        String id = pathInfo.split("/")[1];
        request.setAttribute("id", id);
        Product product = new ProductDAO().getOne(Integer.parseInt(id));
        request.setAttribute("product", product);
        
        
        request.getRequestDispatcher("/product-detail.jsp").forward(request, response);
        
    }
}
