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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                Cart_Item cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                allCart_Items.add(cart_Item);
            }
            ps.close();
            rs.close();
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                ps.close();
                rs.close();
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                Cart_Item cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                list.add(cart_Item);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Cart_Item cart_Item) {
        int id = cart_Item.getItemID();
        xSql = "update Cart_Items " + cart_Item.forUpdate() + " where ItemID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Cart_Item cart_Item) {
        xSql = "insert into Cart_Items (UserID, Total)"
                + " values " + cart_Item.forInsert();
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
        xSql = "delete from Cart_Items where ItemID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
