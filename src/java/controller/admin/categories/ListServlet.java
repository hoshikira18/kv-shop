/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.categories;

import controller.CategoriesController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Category;
import models.Log;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/categories"})
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log(this.getClass().getName(), req);
        PrintWriter out = resp.getWriter();
    CategoriesController cc = new CategoriesController();

    List<Category> cs = cc.getAllCategories();
    req.setAttribute("cs", cs);
        req.getRequestDispatcher("/admin/categories.jsp").forward(req, resp);

    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log(this.getClass().getName(), req);
        PrintWriter out = resp.getWriter();
        CategoriesController cc = new CategoriesController();

        List<Category> cs = cc.getAllCategories();
        req.setAttribute("cs", cs);
        req.getRequestDispatcher("/admin/categories.jsp").forward(req, resp);

    }
}
