/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VIET
 */
public class CartDAO extends MyDAO {

    public List<Cart> getAllCarts() {
        List<Cart> allCarts = new ArrayList<>();
        xSql = "select * from Carts";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");

                Cart cart = new Cart(cartID, userID, total, create_At);
                allCarts.add(cart);
            }
            ps.close();
            rs.close();
            return allCarts;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allCarts;
    }

    public Cart getOne(int id) {
        xSql = "select * from Carts where CartID = " + id;
        Cart cart = new Cart();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");

                cart = new Cart(cartID, userID, total, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart;
    }
    
    public Cart getCartByUser(int id) {
        xSql = "select * from Carts where UserID = " + id;
        Cart cart = new Cart();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");

                cart = new Cart(cartID, userID, total, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart;
    }

    public List<Cart> getList(String requirement) {
        List<Cart> list = new ArrayList<>();
        xSql = "select * from Carts where " + requirement;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");

                Cart cart = new Cart(cartID, userID, total, create_At);
                list.add(cart);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Cart cart) {
        int id = cart.getCartID();
        xSql = "update Carts " + cart.forUpdate() + " where CartID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Cart cart) {
        List<Cart> list = getAllCarts();
        for (Cart cart1 : list) {
            if(cart1.userID == cart.userID){
                return;
            }
        }
        xSql = "insert into Carts (UserID, Total)"
                + " values " + cart.forInsert();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        xSql = "delete from Carts where CartID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Cart_Item> getListItems(int id) {
        List<Cart_Item> list = new ArrayList<>();
        xSql = "select * from Cart_Items where OrderID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                Cart_Item cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                list.add(cart_Item);
                
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Cart getCartOfCustomer(int id){
        xSql = "select * from Carts where UserID = " + id;
        Cart cart = new Cart();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");

                cart = new Cart(cartID, userID, total, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart;
    }
}
