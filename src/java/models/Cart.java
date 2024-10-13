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
public class Cart {

    int cartID;
    int userID;
    double total;
    Date create_at;

    public Cart() {
    }

    public Cart(int userID, double total) {
        this.userID = userID;
        this.total = total;
    }

    public Cart(int carID, int userID, double total, Date create_at) {
        this.cartID = carID;
        this.userID = userID;
        this.total = total;
        this.create_at = create_at;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String forUpdate() {
        String space = ", ";
        String string = "set Total = " + total;
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "(" + userID + ", " + total + ")";
        return insert;
    }
}
