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

    public List<Order> getAllOrders(boolean isAsc) {
        List<Order> allOrders = new ArrayList<>();
        String orderBy;
        if (isAsc) {
            orderBy = " order by Create_At asc";
        } else {
            orderBy = " order by Create_At desc";
        }
        xSql = "select * from Orders" + orderBy;
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

    public String[] getRelatedInfor(int idOfOrder) {
        xSql = """
               select o.OrderID, o.UserID, o.Total, o.Status, o.Create_At,
                 u.UserName, u.Age, u.Address, u.Email, u.PhoneNumber from Orders o
                 join Users u on o.UserID = u.UserID
                 where o.OrderID = """ + idOfOrder;
//        0:OrderID; 1:UserID; 2:Total; 3:Create_At; 4:Status;
//        5:UserName; 6:Age; 7:Address; 8:Email; 9:PhoneNumber;
        String[] order = new String[10];
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                order[0] = rs.getString("OrderID");
                order[1] = rs.getString("UserID");
                order[2] = rs.getString("Total");
                order[3] = rs.getString("Create_At");
                order[4] = rs.getString("Status");
                order[5] = rs.getString("UserName");
                order[6] = rs.getString("Age");
                order[7] = rs.getString("Address");
                order[8] = rs.getString("Email");
                order[9] = rs.getString("phoneNumber");

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
    
    public void updateStatus(int orderID, String status) {
        xSql = "update Orders set Status = N'" + status + "' where OrderID = " + orderID;
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

    public List<Order> getAllOrdersOfCustomer(int id) {
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
