package controller.admin.products;

import controller.CategoriesController;
import controller.ProductsController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import models.Category;
import models.Log;
import models.Product;
import models.ProductDAO;
import models.Supplier;
import models.SupplierDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/edit-product/*"})
@MultipartConfig
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();

        // lay ra san pham bang id
        String id = pathInfo.split("/")[1];
        Log log = new Log(this.getClass().getName(), request, Integer.parseInt(id));
        request.setAttribute("id", id);
        Product product = new ProductDAO().getOne(Integer.parseInt(id));
        List<Product> relatedProducts = new ProductDAO().getProductsByCategory(11);
        
        // get list suppliers and categories
        SupplierDAO sd = new SupplierDAO();
        List<Supplier> ss = sd.getAllSuppliers();
        
        CategoriesController cc = new CategoriesController();
        List<Category> cs = cc.getAllCategories();

        request.setAttribute("ss", ss);
        request.setAttribute("cs", cs);
        
        request.setAttribute("product", product);
        request.setAttribute("relatedProducts", relatedProducts);
        request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the full path info (e.g., "/pid_1234")
        PrintWriter out = response.getWriter();

        String pathInfo = request.getPathInfo();

        // lay ra san pham bang id
        String id = pathInfo.split("/")[1];
        Log log = new Log(this.getClass().getName(), request, Integer.parseInt(id));
        request.setAttribute("id", id);
        Product product = new ProductDAO().getOne(Integer.parseInt(id));
        
        int proID = Integer.parseInt(id);
        String productName = (String) request.getParameter("product-name");
        int supplierID = Integer.parseInt(request.getParameter("product-supplier"));
        int categoryID = Integer.parseInt(request.getParameter("product-category"));
        int price = Integer.parseInt(request.getParameter("product-price"));
        int inventory = Integer.parseInt(request.getParameter("product-inventory"));
//        String image = this.image((Part) request.getPart("product-image"));

        ProductsController pc = new ProductsController();
        Product updatedProduct = new Product(proID, productName, "image", price, supplierID, 11, inventory, "X, XL", "asd", "asd", "asd");
        pc.updateProduct(updatedProduct);
        
        // get list suppliers and categories
        SupplierDAO sd = new SupplierDAO();
        List<Supplier> ss = sd.getAllSuppliers();
        
        CategoriesController cc = new CategoriesController();
        List<Category> cs = cc.getAllCategories();

        request.setAttribute("ss", ss);
        request.setAttribute("cs", cs);
        
        request.setAttribute("product", product);
        out.print(productName);
        request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
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
