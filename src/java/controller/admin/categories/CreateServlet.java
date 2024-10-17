/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.categories;

import controller.CategoriesController;
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
import models.Category;
import models.Log;

/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/admin/categories/create"})
@MultipartConfig
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        String categoryName = (String) req.getParameter("category-name");
        String image = this.image((Part) req.getPart("category-image"));
        CategoriesController cc = new CategoriesController();
        Category category = new Category(categoryName, image);
        cc.insertCategory(category);
        category = cc.getNewest();
        Log log = new Log(this.getClass().getName(), req, category, true);
        resp.sendRedirect("/shop/admin/categories");
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
