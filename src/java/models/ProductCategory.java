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
public class ProductCategory {

    int proCateID;
    int proID;
    int categoryID;
    Date create_at;

    public ProductCategory() {
    }

    public ProductCategory(int proID, int categoryID) {
        this.proID = proID;
        this.categoryID = categoryID;
    }

    public ProductCategory(int proCateID, int proID, int categoryID, Date create_at) {
        this.proCateID = proCateID;
        this.proID = proID;
        this.categoryID = categoryID;
        this.create_at = create_at;
    }

    public int getProCateID() {
        return proCateID;
    }

    public void setProCateID(int proCateID) {
        this.proCateID = proCateID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String forUpdate() {
        String space = ", ";
        String string = "set ProID = " + proID + ", CategoryID = " + categoryID;
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "(" + proID + "," + categoryID + ")";
        return insert;
    }
}
