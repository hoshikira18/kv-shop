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
public class OrderDAO extends MyDAO{
    public List<Order> getAllOrders() {
        List<Order> allOrders = new ArrayList<>();
        xSql = "select * from Orders";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int orderID = Integer.parseInt(result.getString("orderID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Order order = new Order(orderID, userID, total, create_At);
                allOrders.add(order);
            }
            connect.close();
            result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int orderID = Integer.parseInt(result.getString("orderID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                order = new Order(orderID, userID, total, create_At);
                connect.close();
                result.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }
    
    public List<Order> getOrdersByUser(int id) {
        List<Order> listOrders = new ArrayList<>();
        xSql = "select * from Orders where UserID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int orderID = Integer.parseInt(result.getString("orderID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Order order = new Order(orderID, userID, total, create_At);
                listOrders.add(order);
            }
            connect.close();
            result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int orderID = Integer.parseInt(result.getString("orderID"));
                int userID = Integer.parseInt(result.getString("userID"));
                int total = Integer.parseInt(result.getString("total"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Order order = new Order(orderID, userID, total, create_At);
                list.add(order);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Order order) {
        int id = order.getOrderID();
        xSql = "update Orders " + order.forUpdate() + " where orderID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Order order) {
        xSql = "insert into Orders (UserID, Total)"
                + " value " + order.forInsert();
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
        xSql = "delete from Orders where orderID = " + id;
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
