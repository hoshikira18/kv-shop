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
public class Order_ItemDAO extends MyDAO{
    public List<Order_Item> getAllOrder_Items() {
        List<Order_Item> allOrder_Items = new ArrayList<>();
        xSql = "select * from Order_Items";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int itemID = Integer.parseInt(result.getString("itemID"));
                int userID = Integer.parseInt(result.getString("orderID"));
                int proID = Integer.parseInt(result.getString("proID"));
                int total = Integer.parseInt(result.getString("quantity"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Order_Item order_Item = new Order_Item(itemID, proID, proID, userID, create_At);
                allOrder_Items.add(order_Item);
            }
            connect.close();
            result.close();
            return allOrder_Items;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allOrder_Items;
    }

    public Order_Item getOne(int id) {
        xSql = "select * from Order_Items where itemID = " + id;
        Order_Item order_Item = new Order_Item();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int itemID = Integer.parseInt(result.getString("itemID"));
                int userID = Integer.parseInt(result.getString("orderID"));
                int proID = Integer.parseInt(result.getString("proID"));
                int total = Integer.parseInt(result.getString("quantity"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                order_Item = new Order_Item(itemID, proID, proID, userID, create_At);
                connect.close();
                result.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order_Item;
    }

    public List<Order_Item> getList(String requirement) {
        List<Order_Item> list = new ArrayList<>();
        xSql = "select * from Order_Items where " + requirement;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int itemID = Integer.parseInt(result.getString("itemID"));
                int userID = Integer.parseInt(result.getString("orderID"));
                int proID = Integer.parseInt(result.getString("proID"));
                int total = Integer.parseInt(result.getString("quantity"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Order_Item order_Item = new Order_Item(itemID, proID, proID, userID, create_At);
                list.add(order_Item);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Order_Item order_Item) {
        int id = order_Item.getItemID();
        xSql = "update Order_Items " + order_Item.forUpdate() + " where itemID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Order_Item order_Item) {
        xSql = "insert into Order_Items (UserID, Total)"
                + " value " + order_Item.forInsert();
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
        xSql = "delete from Order_Items where itemID = " + id;
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
