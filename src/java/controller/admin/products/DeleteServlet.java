/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.products;

import controller.CategoriesController;
import controller.ProductsController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import models.Category;
import models.Log;
import models.Product;
import models.Supplier;
import models.SupplierDAO;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/products/delete-product"})
@MultipartConfig
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        int productId = Integer.parseInt(req.getParameter("product-id"));
        out.print(productId);

        ProductsController pc = new ProductsController();
        pc.deleteProduct(productId);
        
        List<Product> ps = pc.getAllProducts();
        req.setAttribute("ps", ps);

        resp.sendRedirect("/shop/admin/products");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        int productId = Integer.parseInt(req.getParameter("product-id"));

        ProductsController pc = new ProductsController();
        pc.deleteProduct(productId);
        
        List<Product> ps = pc.getAllProducts();
        req.setAttribute("ps", ps);

        resp.sendRedirect("/shop/admin/products");
    }


}
