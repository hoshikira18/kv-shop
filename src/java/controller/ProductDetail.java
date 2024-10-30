package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Log;
import models.Product;
import models.ProductCategory;
import models.ProductCategoryDAO;
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
public class ProductDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();

//        out.print(pathInfo);

        String id = pathInfo.split("/")[1];
        Log log = new Log(this.getClass().getName(), request, Integer.parseInt(id));
        request.setAttribute("id", id);
        Product product = new ProductDAO().getOne(Integer.parseInt(id));
        String[] sizes = product.getSize().split(",");
        
        ProductCategory pc = new ProductCategoryDAO().getOne(Integer.parseInt(id));
        
        
        List<Product> relatedProducts = new ProductDAO().getProductsByCategory(pc.getCategoryID());
        
        out.print(pc.getCategoryID());
        
        request.setAttribute("product", product);
        request.setAttribute("sizes", sizes);
        request.setAttribute("relatedProducts", relatedProducts);
        
        request.getRequestDispatcher("/product/product-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();

        out.print(pathInfo);

        String id = pathInfo.split("/")[1];
        Log log = new Log(this.getClass().getName(), request, Integer.parseInt(id));
        request.setAttribute("id", id);
        Product product = new ProductDAO().getOne(Integer.parseInt(id));
        List<Product> relatedProducts = new ProductDAO().getProductsByCategory(11);
        request.setAttribute("product", product);
        request.setAttribute("relatedProducts", relatedProducts);
        request.getRequestDispatcher("/product/product-detail.jsp").forward(request, response);
    }
}
