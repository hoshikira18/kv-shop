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
public class OrderDAO extends MyDAO {

    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        xSql = "select * from Orders";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");
                String status = rs.getString("Status");

                Order order = new Order(orderID, userID, total, create_At, status);
                allOrders.add(order);
            }
            ps.close();
            rs.close();
            return allOrders;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allOrders;
    }

    public Order getOne(int id) {
        xSql = "select * from Orders where OrderID = " + id;
        Order order = new Order();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");
                String status = rs.getString("Status");

                order = new Order(orderID, userID, total, create_At, status);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }
    
    public Order getNewestOfUser(int userIDMain) {
        xSql = "select top 1 * from Orders where UserID = " + userIDMain + " order by Create_At desc";
        Order order = new Order();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");
                String status = rs.getString("Status");

                order = new Order(orderID, userID, total, create_At, status);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }

    public List<Order> getOrdersByUser(int id) {
        List<Order> listOrders = new ArrayList<>();
        xSql = "select * from Orders where UserID = " + id + " order by Create_At desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");
                String status = rs.getString("Status");

                Order order = new Order(orderID, userID, total, create_At, status);
                listOrders.add(order);
            }
            ps.close();
            rs.close();
            return listOrders;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listOrders;
    }

    public List<Order> getList(String requirement) {
        List<Order> list = new ArrayList<>();
        xSql = "select * from Orders where " + requirement;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");
                String status = rs.getString("Status");

                Order order = new Order(orderID, userID, total, create_At, status);
                list.add(order);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Order order) {
        int id = order.getOrderID();
        xSql = "update Orders " + order.forUpdate() + " where OrderID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Order order) {
        xSql = "insert into Orders (UserID, Total, Status)"
                + " values " + order.forInsert();
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
        xSql = "delete from Orders where OrderID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Order_Item> getListItems(int id) {
        List<Order_Item> list = new ArrayList<>();
        xSql = "select * from Order_Items where OrderID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                String proSize = rs.getString("ProSize");

                Order_Item order_Item = new Order_Item(itemID, orderID, proID, quantity, proSize);
                list.add(order_Item);
                
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Order> getAllOrdersOfCustomer(int id){
        List<Order> list = new ArrayList<>();
        xSql = "select * from Orders where UserID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int orderID = Integer.parseInt(rs.getString("OrderID"));
                int userID = Integer.parseInt(rs.getString("UserID"));
                double total = Double.parseDouble(rs.getString("Total"));
                Date create_At = rs.getDate("Create_At");
                String status = rs.getString("Status");

                Order order = new Order(orderID, userID, total, create_At, status);
                list.add(order);
                
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
