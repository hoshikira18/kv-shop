/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author khuye
 */
public class UserDAO extends MyDAO {

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        xSql = "select * from Users";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int ID = Integer.parseInt(result.getString("userID"));
                String userName = result.getString("userName");
                int age = Integer.parseInt(result.getString("age"));
                String phoneNumber = result.getString("phoneNumber");
                String address = result.getString("address");
                String email = result.getString("email");
                String password = result.getString("password");
                int roleID = Integer.parseInt(result.getString("roleID"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                User user = new User(ID, userName, age, phoneNumber, address,
                         email, password, roleID, create_At);
                allUsers.add(user);
            }
            connect.close();
            result.close();
            return allUsers;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allUsers;
    }

    public User getOne(int id) {
        xSql = "select * from Users where UserID = " + id;
        User user = new User();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if(result.next()){
            int ID = Integer.parseInt(result.getString("userID"));
            String userName = result.getString("userName");
            int age = Integer.parseInt(result.getString("age"));
            String phoneNumber = result.getString("phoneNumber");
            String address = result.getString("address");
            String email = result.getString("email");
            String password = result.getString("password");
            int roleID = Integer.parseInt(result.getString("roleID"));
            Date create_At = Date.valueOf(result.getString("create_At"));

            user = new User(ID, userName, age, phoneNumber, address,
                     email, password, roleID, create_At);
            }
            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }
    
    public List<User> getList(String requirement) {
        List<User> list = new ArrayList<>();
        xSql = "select * from Users where "+requirement ;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int ID = Integer.parseInt(result.getString("userID"));
                String userName = result.getString("userName");
                int age = Integer.parseInt(result.getString("age"));
                String phoneNumber = result.getString("phoneNumber");
                String address = result.getString("address");
                String email = result.getString("email");
                String password = result.getString("password");
                int roleID = Integer.parseInt(result.getString("roleID"));
                Date create_At = Date.valueOf(result.getString("create_At"));

                User user = new User(ID, userName, age, phoneNumber, address,
                         email, password, roleID, create_At);
                list.add(user);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(User user) {
        int id = user.getUserID();
        xSql = "update Users "+user.forUpdate()+" where userID = "+id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            
            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insert(User user){
        xSql = "insert into Users (UserName, Age, PhoneNumber, Address, Email, Password, RoleID)"
                + " value "+user.forInsert();
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
        xSql = "delete from Users where userID = "+id;
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
