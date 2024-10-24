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
import models.Category;
import models.CategoryDAO;
import models.Log;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/delete-category"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        CategoriesController cc = new CategoriesController();
        int id = Integer.parseInt(req.getParameter("category-id"));
        Category category = new CategoryDAO().getOne(id);
        Log log = new Log(this.getClass().getName(), req, category, false);
        cc.deleteCategory(id);
        req.getRequestDispatcher("/admin/categories").forward(req, resp);
    }
    
}
