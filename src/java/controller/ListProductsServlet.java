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
@WebServlet(urlPatterns = {"/products"})
public class ListProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int loadCount = 1;
        ProductDAO pd = new ProductDAO();
        List<Product> allProducts = new ArrayList<>();
        CategoryDAO cc = new CategoryDAO();
        List<Category> listCate = cc.getAllCategories();

        allProducts = new ProductDAO().getAllProducts();
        List<Product> list2 = pd.getTop(8, "desc");

        req.setAttribute("list2", list2);
        req.setAttribute("categories", listCate);
        req.setAttribute("loadCount", loadCount);
        Log log = new Log(this.getClass().getName(), req);
        req.setAttribute("allProducts", allProducts);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }

}
