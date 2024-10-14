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
public class ProductDAO extends MyDAO {

    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        xSql = "select * from Products";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(supID, productName, image, price, supID, inventory, create_At);
                allProducts.add(product);
            }
            ps.close();
            rs.close();
            return allProducts;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allProducts;
    }

    public Product getOne(int id) {
        xSql = "select * from Products where ProID = " + id;
        Product product = new Product();
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                product = new Product(supID, productName, image, price, supID, inventory, create_At);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }

    public List<Product> getList(String requirement) {
        List<Product> list = new ArrayList<>();
        xSql = "select * from Products where " + requirement;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(supID, productName, image, price, supID, inventory, create_At);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getTop(int n) {
        List<Product> list = new ArrayList<>();
        xSql = "select top " + n + " * from Products";
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(supID, productName, image, price, supID, inventory, create_At);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Product product) {
        int id = product.getProID();
        xSql = "update Products " + product.forUpdate() + " where ProID = " + id;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Product product) {
        xSql = "insert into Products (ProName, Image, Price, SupID, Inventory)"
                + " values " + product.forInsert();
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        xSql = "delete from Products where ProID = " + id;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
