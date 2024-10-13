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
    Date create_at;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
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

    public String forUpdate() {
        String space = ", ";
        String string = "set CategoryName = '" + categoryName + "'";
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "('" + categoryName + "')";
        return insert;
    }

}
