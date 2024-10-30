/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author VIET
 */
public class Order_Item {

    int itemID;
    int orderID;
    int proID;
    int quantity;
    String proSize;

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public Order_Item() {
    }

    public Order_Item(int orderID, int proID, int quantity) {
        this.orderID = orderID;
        this.proID = proID;
        this.quantity = quantity;
    }

    public Order_Item(int orderID, int proID, int quantity, String proSize) {
        this.orderID = orderID;
        this.proID = proID;
        this.quantity = quantity;
        this.proSize = proSize;
    }

    public Order_Item(int itemID, int orderID, int proID, int quantity, String proSize) {
        this.itemID = itemID;
        this.orderID = orderID;
        this.proID = proID;
        this.quantity = quantity;
        this.proSize = proSize;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String forUpdate() {
        String space = ", ";
        String string = "set ProID = " + proID + space + "Quantity = "
                + quantity + space + "ProSize = N'" + proSize + "'";
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "(" + orderID + ", " + proID + ", " + quantity + ", N'" + proSize + "')";
        return insert;
    }

}
