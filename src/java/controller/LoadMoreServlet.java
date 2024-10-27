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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.CategoryDAO;
import models.Log;
import models.Product;
import models.ProductDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/loadMore"})
public class LoadMoreServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        String count = (String) req.getParameter("loadCount");
        int loadCount = Integer.parseInt(count) + 1;
        
        ProductDAO pd = new ProductDAO();
        CategoryDAO cc = new CategoryDAO();
        List<Category> listCate = cc.getAllCategories();
        
        List<Product> allProducts = pd.getAllProducts();
        int getQuantity = loadCount * 8;
        List<Product> list2 = pd.getTop(getQuantity, "desc");
        
        req.setAttribute("list2", list2);
        req.setAttribute("loadCount", loadCount);
        Log log = new Log(this.getClass().getName(), req);
        req.setAttribute("allProducts", allProducts);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
        
    }
    
    
}
