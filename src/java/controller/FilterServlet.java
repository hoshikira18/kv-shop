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
import java.util.List;
import models.Category;
import models.CategoryDAO;
import models.Product;
import models.ProductDAO;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/filter"})
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String keyword = (String) req.getParameter("keyword");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        double minPrice = Double.parseDouble(req.getParameter("minPrice"));
        double maxPrice = Double.parseDouble(req.getParameter("maxPrice"));
        
        CategoryDAO cc = new CategoryDAO();
        List<Category> listCate = cc.getAllCategories();
        
        req.setAttribute("categories", listCate);
        
        List<Product> products = new ProductDAO().filterProduct(keyword, categoryId, minPrice, maxPrice);
        out.print((products.size()));
        
        req.setAttribute("list2", products);
        req.getRequestDispatcher("products.jsp").forward(req, resp);

    }

}
