/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.products;

import controller.CategoriesController;
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
import models.Product;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/products"})
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log(this.getClass().getName(), req);
        PrintWriter out = resp.getWriter();
        ProductsController pc = new ProductsController();

        // ps = products
        List<Product> ps = pc.getAllProducts();
        out.print(ps.size());
        req.setAttribute("ps", ps);
        req.getRequestDispatcher("/admin/products.jsp").forward(req, resp);

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log(this.getClass().getName(), req);
        PrintWriter out = resp.getWriter();
        ProductsController pc = new ProductsController();

        // ps = products
        List<Product> ps = pc.getAllProducts();
        req.setAttribute("ps", ps);
        req.getRequestDispatcher("/admin/products.jsp").forward(req, resp);

    }
}
