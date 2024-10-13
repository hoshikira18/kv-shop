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
public class ProductsController {

    ProductDAO pd = new ProductDAO();
    
    public ProductsController() {
    }
    
    public List<Product> getAllProducts() {
        return pd.getAllProducts();
    }
    
    public void createProduct(Product p, int categoryID) {
        Product product = pd.insert(p);
        ProductCategoryDAO pcd = new ProductCategoryDAO();
        
        if (product != null) {
            System.out.println("Done");
            pcd.insert(new ProductCategory(product.getProID(), categoryID));
        }
    }
}
