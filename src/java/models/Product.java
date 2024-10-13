/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author VIET
 */
public class Product {
    int proID;
    String proName;
    String image;
    double price;
    int supID;
    int inventory;
    Date create_at;

    public Product() {
    }

    public Product(String proName, String image, double price, int supID, int inventory) {
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.inventory = inventory;
    }

    public Product(int proID, String proName, String image, double price, int supID, int inventory) {
        this.proID = proID;
        this.proName = proName;
        this.image = image;
        this.price = price;
        this.supID = supID;
        this.inventory = inventory;
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
    
    public String forUpdate() {
        String space = ", ";
        String string = "set proName = '" + proName + "'" + space + "image = '" 
                + image + "'" + space
                + "price = " + price + space + "supID = "
                + supID + space + "inventory = " + inventory;
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "('" + proName + "', '" + image + "', " + price + ", "
                + supID + ", " + inventory + ")";
        return insert;
    }
}
