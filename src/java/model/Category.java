/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author VIET
 */
public class Category {
    int categoryID;
    String categoryName;
    Date create_at;
    ArrayList<Product> listProducts = new ArrayList<>();

    public Category() {
    }

    public Category(int categoryID, String categoryName, Date create_at) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.create_at = create_at;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public ArrayList<Product> getListProduct() {
        return listProducts;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProducts = listProduct;
    }
    
    public void add(Product product){
        this.listProducts.add(product);
    }
    
    public void remove(Product product){
        Product proDelete = new Product();
        for (Product listProduct : listProducts) {
            if(product.proID == listProduct.proID){
                proDelete = listProduct;
                break;
            }
        }
        listProducts.remove(proDelete);
    }
    
}
