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
 */public class CategoryDAO extends MyDAO {

    public List<Category> getAllCategories() {
        List<Category> allCategories = new ArrayList<>();
        xSql = "select * from Categories";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int categoryID = Integer.parseInt(rs.getString("CategoryID"));
                String categoryName = rs.getString("CategoryName");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                Date create_At = rs.getDate("Create_At");

                Category category = new Category(categoryID, categoryName, image, create_At);
                allCategories.add(category);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allCategories;
    }

    public Category getOne(int id) {
        xSql = "select * from Categories where CategoryID = " + id;
        Category category = new Category();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int categoryID = Integer.parseInt(rs.getString("CategoryID"));
                String categoryName = rs.getString("CategoryName");
                String image = rs.getString("Image");
                Date create_At = rs.getDate("Create_At");

                category = new Category(categoryID, categoryName, image, create_At);
                ps.close();
                rs.close();
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int categoryID = Integer.parseInt(rs.getString("CategoryID"));
                String categoryName = rs.getString("CategoryName");
                String image = rs.getString("Image");
                Date create_At = rs.getDate("Create_At");

                Category category = new Category(categoryID, categoryName, image, create_At);
                list.add(category);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Category category) {
        int id = category.getCategoryID();
        xSql = "update Categories " + category.forUpdate() + " where CategoryID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Category category) {
        xSql = "insert into Categories (CategoryName, Image)"
                + " values " + category.forInsert();
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
        xSql = "delete from Categories where CategoryID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Category getNewest(){
        xSql = "select top 1 * from Categories order by Create_At desc";
        Category category = new Category();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int categoryID = Integer.parseInt(rs.getString("CategoryID"));
                String categoryName = rs.getString("CategoryName");
                String image = rs.getString("Image");
                Date create_At = rs.getDate("Create_At");

                category = new Category(categoryID, categoryName, image, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return category;
    }
}
