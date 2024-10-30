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
public class ProductCategoryDAO extends MyDAO {

    public List<ProductCategory> getAllProductCategorys() {
        List<ProductCategory> allProductCategorys = new ArrayList<>();
        xSql = "select * from ProductCategories";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int proCateID = Integer.parseInt(result.getString("ProCateID"));
                int proID = Integer.parseInt(result.getString("ProID"));
                int categoryID = Integer.parseInt(result.getString("CategoryID"));
                Date create_At = result.getDate("Create_At");

                ProductCategory proCate = new ProductCategory(proCateID, proID, categoryID, create_At);
                allProductCategorys.add(proCate);
            }
            connect.close();
            result.close();
            return allProductCategorys;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allProductCategorys;
    }

    public ProductCategory getOne(int id) {
        xSql = "select * from ProductCategories where ProID = " + id;
        ProductCategory proCate = new ProductCategory();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int proCateID = Integer.parseInt(result.getString("ProCateID"));
                int proID = Integer.parseInt(result.getString("ProID"));
                int categoryID = Integer.parseInt(result.getString("CategoryID"));
                Date create_At = result.getDate("Create_At");

                proCate = new ProductCategory(proCateID, proID, categoryID, create_At);
                connect.close();
                result.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return proCate;
    }

    public List<ProductCategory> getList(String requirement) {
        List<ProductCategory> list = new ArrayList<>();
        xSql = "select * from ProductCategories where " + requirement;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int proCateID = Integer.parseInt(result.getString("ProCateID"));
                int proID = Integer.parseInt(result.getString("ProID"));
                int categoryID = Integer.parseInt(result.getString("CategoryID"));
                Date create_At = result.getDate("Create_At");

                ProductCategory proCate = new ProductCategory(proCateID, proID, categoryID, create_At);
                list.add(proCate);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(ProductCategory proCate) {
        int id = proCate.getProCateID();
        xSql = "update ProductCategories " + proCate.forUpdate() + " where ProCateID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(ProductCategory proCate) {

        xSql = "insert into ProductCategories (ProID, CategoryID)"
                + " values " + "(" + proCate.proID + ","  + proCate.categoryID + ")";
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
        xSql = "delete from ProductCategories where ProCateID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteByCategoryID(int CategoryID) {
        xSql = "delete from ProductCategories where CategoryID = " + CategoryID;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteByProductID(int ProductID) {
        xSql = "delete from ProductCategories where ProID = " + ProductID;
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
