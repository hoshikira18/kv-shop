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
public class ProductDAO extends MyDAO{
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        xSql = "select * from Products";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int ID = Integer.parseInt(result.getString("proID"));
                String productName = result.getString("proName");
                String image = result.getString("image");
                double price = Double.parseDouble(result.getString("price"));
                int supID = Integer.parseInt(result.getString("supID"));
                int inventory = Integer.parseInt(result.getString("inventory"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Product product = new Product(supID, productName, image, price, supID, inventory);
                allProducts.add(product);
            }
            connect.close();
            result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if(result.next()){
            int ID = Integer.parseInt(result.getString("proID"));
                String productName = result.getString("proName");
                String image = result.getString("image");
                double price = Double.parseDouble(result.getString("price"));
                int supID = Integer.parseInt(result.getString("supID"));
                int inventory = Integer.parseInt(result.getString("inventory"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                product = new Product(supID, productName, image, price, supID, inventory);
            }
            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }
    
    public List<Product> getList(String requirement) {
        List<Product> list = new ArrayList<>();
        xSql = "select * from Products where "+requirement ;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int ID = Integer.parseInt(result.getString("proID"));
                String productName = result.getString("proName");
                String image = result.getString("image");
                double price = Double.parseDouble(result.getString("price"));
                int supID = Integer.parseInt(result.getString("supID"));
                int inventory = Integer.parseInt(result.getString("inventory"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                Product product = new Product(supID, productName, image, price, supID, inventory);
                list.add(product);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Product product) {
        int id = product.getProID();
        xSql = "update Products "+product.forUpdate()+" where proID = "+id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            
            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insert(Product product){
        xSql = "insert into Products (ProName, image, price, supID, inventory)"
                + " value "+product.forInsert();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            
            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void delete(int id){
        xSql = "delete from Products where proID = "+id;
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
