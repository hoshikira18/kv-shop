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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
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

    public List<Product> getProductsByCategory(int categoryID) {
        List<Product> products = new ArrayList<>();
        xSql = "select * from Products where ProID in (select ProID from ProductCategories where CategoryID = " + categoryID + ")";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
                products.add(product);
            }
            ps.close();
            rs.close();
            return products;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;

    }

    public List<Product> getAllProductsDown() {
        List<Product> allProducts = new ArrayList<>();
        xSql = "select * from Products order by create_At desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
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
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                product = new Product(ID, productName, image, price, supID, inventory, create_At);
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
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
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

    public List<Product> getTop(int n, String ascOrDesc) {
        List<Product> list = new ArrayList<>();
        xSql = "select top " + n + " * from Products order by ProID " + ascOrDesc;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
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

    public Product insert(Product product) {
        xSql = "insert into Products (Pro_Name, Image, Price, SupID, Inventory, Size, Description)"
                + " values " + product.forInsert();

        Product p = null;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        p = getNewestProduct();

        return p;
    }

    public Product getNewestProduct() {
        xSql = "select top(1) * from Products order by Create_At desc";
        Product product = null;

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                product = new Product(ID, productName, image, price, supID, inventory);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return product;
    }

    public void delete(int id) {
        xSql = "delete from Cart_Items where ProID = " + id +";delete from ProductCategories where ProID = " + id + ";delete from Products where ProID = " + id;
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
