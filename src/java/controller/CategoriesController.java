/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import models.*;

/**
 *
 * @author khuye
 */
public class CategoriesController {
    CategoryDAO cd = new CategoryDAO();
    ProductCategoryDAO pcd = new ProductCategoryDAO();

    public CategoriesController() {
    }
    
    public List<Category> getAllCategories () {
        return cd.getAllCategories();
    }
    
    public void insertCategory (Category c) {
        cd.insert(c);
    }
    
    public void deleteCategory (int id) {
        pcd.deleteByCategoryID(id);
        cd.delete(id);
    }
    
    public Category getNewest(){
        return cd.getNewest();
    }
}
