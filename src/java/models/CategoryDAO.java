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
public class CategoryDAO extends MyDAO {

    public List<Category> getAllCategorys() {
        List<Category> allCategorys = new ArrayList<>();
        xSql = "select * from Categories";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int categoryID = Integer.parseInt(result.getString("categoryID"));
                String categoryName = result.getString("categoryName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                Category category = new Category(categoryID, categoryName, create_At);
                allCategorys.add(category);
            }
            connect.close();
            result.close();
            return allCategorys;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allCategorys;
    }

    public Category getOne(int id) {
        xSql = "select * from Categories where CategoryID = " + id;
        Category category = new Category();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int categoryID = Integer.parseInt(result.getString("categoryID"));
                String categoryName = result.getString("categoryName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                category = new Category(categoryID, categoryName, create_At);
                connect.close();
                result.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return category;
    }

    public List<Category> getList(String requirement) {
        List<Category> list = new ArrayList<>();
        xSql = "select * from Categories where " + requirement;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int categoryID = Integer.parseInt(result.getString("categoryID"));
                String categoryName = result.getString("categoryName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                Category category = new Category(categoryID, categoryName, create_At);
                list.add(category);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Category category) {
        int id = category.getCategoryID();
        xSql = "update Categories " + category.forUpdate() + " where categoryID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Category category) {
        xSql = "insert into Categories (CategoryName)"
                + " value " + category.forInsert();
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
        xSql = "delete from Categories where categoryID = " + id;
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
