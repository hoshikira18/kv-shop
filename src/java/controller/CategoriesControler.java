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
public class CategoriesControler {
    CategoryDAO cd = new CategoryDAO();

    public CategoriesControler() {
    }
    
    public List<Category> getAllCategories () {
        return cd.getAllCategories();
    }
    
    public void insertCategory (Category c) {
        cd.insert(c);
    }
    
    public void deleteCategory (int id) {
        cd.delete(id);
    }
}
