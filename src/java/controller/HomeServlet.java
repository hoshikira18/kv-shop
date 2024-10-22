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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import models.Product;
import models.ProductDAO;

import java.util.logging.*;
import javax.imageio.ImageIO;
import models.Category;
import models.CategoryDAO;
import models.Log;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log log = new Log(this.getClass().getName(), req);

        PrintWriter out = resp.getWriter();

        ProductDAO pd = new ProductDAO();

        CategoryDAO cc = new CategoryDAO();
        List<Category> listCate = cc.getAllCategories();

        List<Product> list = pd.getTop(8, "asc");
        List<Product> list2 = pd.getTop(8, "desc");
        
        req.setAttribute("list2", list2);
        req.setAttribute("list", list);
        req.setAttribute("listCate", listCate);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log log = new Log(this.getClass().getName(), req);

        PrintWriter out = resp.getWriter();

        ProductDAO pd = new ProductDAO();

        CategoryDAO cc = new CategoryDAO();
        List<Category> listCate = cc.getAllCategories();
        
        List<Product> list = pd.getTop(8, "asc");
        List<Product> list2 = pd.getTop(8, "desc");
        
        req.setAttribute("list2", list2);
        req.setAttribute("list", list);
        req.setAttribute("listCate", listCate);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

}
