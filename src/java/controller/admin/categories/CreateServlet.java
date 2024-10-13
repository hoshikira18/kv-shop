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
import models.Category;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/categories/create"})
public class CreateServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String categoryName = (String) req.getParameter("category-name");
        CategoriesController cc = new CategoriesController();
        cc.insertCategory(new Category(categoryName));
        resp.sendRedirect("/shop/admin/categories");
    }
    
}
