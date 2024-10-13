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
public class Supplier {
    int supplierID;
    String supplierName;
    Date create_at;

    public Supplier() {
    }

    public Supplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public Supplier(int supplierID, String supplierName, Date create_at) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.create_at = create_at;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
    public String forUpdate() {
        String space = ", ";
        String string = "set supplierName = '" + supplierName + "'";
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "('" + supplierName+ "')";
        return insert;
    }
}
