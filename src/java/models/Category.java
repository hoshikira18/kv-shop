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
public class Category {

    int categoryID;
    String categoryName;
    String image;
    Date create_at;

    public Category() {
    }

    public Category(String categoryName, String image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public Category(int categoryID, String categoryName, String image, Date create_at) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String forUpdate() {
        String space = ", ";
        String string = "set CategoryName = '" + categoryName + "'" + space + "Image = '" + image + "'";
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "('" + categoryName + "', '" + image + "')";
        return insert;
    }

}
