/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author VIET
 */
public class Product {

    int proID;
    String proName;
    String image;
    double price;
    String supName;
    String cateName;
    int supID;
    int inventory;
    Date create_at;
    String size;
    String description;

    public Product() {
    }

    public Product(int proID, String proName, String image, double price, String supName, String cateName, int inventory, String size, String description) {
        this.proID = proID;
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supName = supName;
        this.cateName = cateName;
        this.inventory = inventory;
        this.size = size;
        this.description = description;
    }

    public Product(int id, String proName, String image, double price, int supID, int inventory) {
        this.proID = id;
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.inventory = inventory;
    }

    public Product(int id, String proName, String image, double price) {
        this.proID = id;
        this.proName = proName;
        this.image = image;
        this.price = price;
    }
    
    public Product(String proName, String image, double price, int supID, int inventory) {
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.inventory = inventory;
    }

    public Product(int proID, String proName, String image, double price, int supID, int inventory, Date create_At) {
        this.proID = proID;
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.inventory = inventory;
        this.create_at = create_At;
    }
    
    public Product(int proID, String proName, String image, double price, int supID, String size, String description) {
        this.proID = proID;
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.size = size;
        this.description = description;
    }

    public Product(int proID, String proName, String image, double price, int supID, int inventory, String size, String description, String supName, String cateName) {
        this.proID = proID;
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.inventory = inventory;
        this.size = size;
        this.description = description;
        this.supName = supName;
        this.cateName = cateName;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupID() {
        return supID;
    }

    public void setSupID(int supID) {
        this.supID = supID;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<String> listSize(){
        return Arrays.asList(this.size.toUpperCase().split(","));
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    
    

    public String forUpdate() {
        String space = ", ";
        String string = "set ProName = '" + proName + "'" + space + "Image = '"
                + image + "'" + space
                + "Price = " + price + space + "SupID = "
                + supID + space + "Inventory = " + inventory + space
                + "Size = '" + size.toUpperCase() + "'" + space + "Description = '" + description + "'";
        return string;
    }

    public String forInsert() {
        String newName = checkName();
        String insert = "";
        insert = "('" + newName + "', '" + image + "', " + price + ", "
                + supID + ", " + inventory + ", '" + size.toUpperCase() + "', '" + description + "')";
        return insert;
    }

    private String checkName() {
        String newName = "";
        if (!this.proName.contains("'")) {
            return this.proName;
        } else {
            String[] list = this.proName.split("[']");
            for (int i = 0; i < list.length - 1; i++) {
                newName += list[i];
                newName += "''";
            }
            newName += list[list.length - 1];
            return newName;
        }
    }
}
