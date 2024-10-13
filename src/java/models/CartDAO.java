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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int cartID = Integer.parseInt(result.getString("cartID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Cart cart = new Cart(cartID, userID, total, create_At);
                allCarts.add(cart);
            }
            connect.close();
            result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int cartID = Integer.parseInt(result.getString("cartID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                cart = new Cart(cartID, userID, total, create_At);
                connect.close();
                result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int cartID = Integer.parseInt(result.getString("cartID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                cart = new Cart(cartID, userID, total, create_At);
                connect.close();
                result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int cartID = Integer.parseInt(result.getString("cartID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Cart cart = new Cart(cartID, userID, total, create_At);
                list.add(cart);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Cart cart) {
        int id = cart.getCartID();
        xSql = "update Carts " + cart.forUpdate() + " where cartID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
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
                + " value " + cart.forInsert();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        xSql = "delete from Carts where cartID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
