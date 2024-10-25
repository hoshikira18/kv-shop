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
        pcd.insert(new ProductCategory(product.getProID(), categoryID));
    }

    public Product getNewest() {
        return pd.getNewestProduct();
    }
    
    public void deleteProduct (int id) {
        pd.delete(id);
    }

}
