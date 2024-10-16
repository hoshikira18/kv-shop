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
public class Cart_Item {
    int itemID;
    int cartID;
    int proID;
    int quantity;
    Date create_at;

    public Cart_Item() {
    }

    public Cart_Item(int CartID, int proID, int quantity) {
        this.cartID = CartID;
        this.proID = proID;
        this.quantity = quantity;
    }

    public Cart_Item(int itemID, int CartID, int proID, int quantity, Date create_at) {
        this.itemID = itemID;
        this.cartID = CartID;
        this.proID = proID;
        this.quantity = quantity;
        this.create_at = create_at;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
    public String forUpdate() {
        String space = ", ";
        String string = "set CroID = " + proID + space + "Quantity = " + quantity;
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "(" + cartID + ", " + proID + ", " + quantity +")";
        return insert;
    }
}
