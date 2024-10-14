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
import models.Category;
import models.Product;
import models.Supplier;
import models.SupplierDAO;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/products/create"})
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String productName = (String) req.getParameter("product-name");
        int supplierID = Integer.parseInt(req.getParameter("product-supplier"));
        int categoryID = Integer.parseInt(req.getParameter("product-category"));
        int price = Integer.parseInt(req.getParameter("product-price"));
        int inventory = Integer.parseInt(req.getParameter("product-inventory"));

        ProductsController pc = new ProductsController();
        Product product = new Product(productName, productName, price, supplierID, inventory);
        pc.createProduct(product, categoryID);
        
        resp.sendRedirect("/shop/admin/products");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        SupplierDAO sd = new SupplierDAO();
        List<Supplier> ss = sd.getAllSuppliers();

        CategoriesController cc = new CategoriesController();
        List<Category> cs = cc.getAllCategories();

        req.setAttribute("ss", ss);
        req.setAttribute("cs", cs);
        req.getRequestDispatcher("/admin/products/create.jsp").forward(req, resp);
    }

}
