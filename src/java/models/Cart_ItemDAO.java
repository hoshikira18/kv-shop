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
public class Cart_ItemDAO extends MyDAO{
    public List<Cart_Item> getAllCart_Items() {
        List<Cart_Item> allCart_Items = new ArrayList<>();
        xSql = "select * from Cart_Items";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int itemID = Integer.parseInt(result.getString("itemID"));
                int userID = Integer.parseInt(result.getString("cartID"));
                int proID = Integer.parseInt(result.getString("proID"));
                int total = Integer.parseInt(result.getString("quantity"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Cart_Item cart_Item = new Cart_Item(itemID, proID, proID, userID, create_At);
                allCart_Items.add(cart_Item);
            }
            connect.close();
            result.close();
            return allCart_Items;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allCart_Items;
    }

    public Cart_Item getOne(int id) {
        xSql = "select * from Cart_Items where itemID = " + id;
        Cart_Item cart_Item = new Cart_Item();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int itemID = Integer.parseInt(result.getString("itemID"));
                int userID = Integer.parseInt(result.getString("cartID"));
                int proID = Integer.parseInt(result.getString("proID"));
                int total = Integer.parseInt(result.getString("quantity"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                cart_Item = new Cart_Item(itemID, proID, proID, userID, create_At);
                connect.close();
                result.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart_Item;
    }

    public List<Cart_Item> getList(String requirement) {
        List<Cart_Item> list = new ArrayList<>();
        xSql = "select * from Cart_Items where " + requirement;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int itemID = Integer.parseInt(result.getString("itemID"));
                int userID = Integer.parseInt(result.getString("cartID"));
                int proID = Integer.parseInt(result.getString("proID"));
                int total = Integer.parseInt(result.getString("quantity"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Cart_Item cart_Item = new Cart_Item(itemID, proID, proID, userID, create_At);
                list.add(cart_Item);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Cart_Item cart_Item) {
        int id = cart_Item.getItemID();
        xSql = "update Cart_Items " + cart_Item.forUpdate() + " where itemID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Cart_Item cart_Item) {
        xSql = "insert into Cart_Items (UserID, Total)"
                + " value " + cart_Item.forInsert();
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
        xSql = "delete from Cart_Items where itemID = " + id;
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
