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
import java.io.File;
import java.io.FileInputStream;
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
@WebServlet(urlPatterns = {"/admin/products/create"})
@MultipartConfig
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String productName = (String) req.getParameter("product-name");
        int supplierID = Integer.parseInt(req.getParameter("product-supplier"));
        int categoryID = Integer.parseInt(req.getParameter("product-category"));
        int price = Integer.parseInt(req.getParameter("product-price"));
        int inventory = Integer.parseInt(req.getParameter("product-inventory"));
        String image = this.image((Part) req.getPart("product-image"));
//        String image = this.image();

        ProductsController pc = new ProductsController();
        Product product = new Product(productName, image, price, supplierID, inventory);
        pc.createProduct(product, categoryID);
        product = pc.getNewest();
        Log log = new Log(this.getClass().getName(), req, product, categoryID);

//        out.print(supplierID + "\n" + categoryID + "\n" + price + "\n" + inventory + "\n" + image );
        resp.sendRedirect("/shop/admin/products");
//        out.println(productName);
//        out.println(product.forInsert());
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

    public String image(Part part) throws IOException {

        long length = part.getSize();
        byte[] buffer = new byte[(int) length];
        InputStream inputStream = part.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        byte[] image = bos.toByteArray();
        String encode = Base64.getEncoder().encodeToString(image);
        return encode;
    }

}
