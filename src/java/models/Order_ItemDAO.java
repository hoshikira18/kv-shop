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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));

                Order_Item order_Item = new Order_Item(itemID, orderID, proID, quantity);
                allOrder_Items.add(order_Item);
            }
            ps.close();
            rs.close();
            return allOrder_Items;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allOrder_Items;
    }

    public Order_Item getOne(int id) {
        xSql = "select * from Order_Items where ItemID = " + id;
        Order_Item order_Item = new Order_Item();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));

                order_Item = new Order_Item(itemID, orderID, proID, quantity);
                ps.close();
                rs.close();
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));

                Order_Item order_Item = new Order_Item(itemID, orderID, proID, quantity);
                list.add(order_Item);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Order_Item order_Item) {
        int id = order_Item.getItemID();
        xSql = "update Order_Items " + order_Item.forUpdate() + " where ItemID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Order_Item order_Item) {
        xSql = "insert into Order_Items (UserID, Total)"
                + " values " + order_Item.forInsert();
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
        xSql = "delete from Order_Items where ItemID = " + id;
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
