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
import java.sql.Date;

/**
 *
 * @author khuye
 */
public class UserDAO extends MyDAO {

    public List<User> getAllUsers1() {
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

    public User createUser(User u) {
        String sql = "insert into Users (UserName, Age, PhoneNumber, Address, Email, Password, RoleID) values (?, ?, ?, ? , ?, ?, ?)";
        ArrayList<User> users = getAllUsers();

        User newUser = null;

        for (User user : users) {
            if (user.getPhoneNumber().equals(u.getPhoneNumber())) {
                newUser = null;
                return newUser;
            }
        }

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getUserName());
            ps.setInt(2, u.getAge());
            ps.setString(3, u.getPhoneNumber());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getPassword());
            ps.setInt(7, u.getRoleID());
            ps.executeUpdate();
            ps.close();

            newUser = getUserByPhoneNumber(u.getPhoneNumber());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT u.*, r.RoleName from Users u left join Roles r on r.RoleID = u.RoleID";

        int Age;
        int id;
        int roleId;
        String userName;
        String PhoneNumber;
        String Address;
        String Email;
        String role;
        Date created_at;

        User u = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("UserID");
                userName = rs.getString("UserName");
                Age = rs.getInt("Age");
                PhoneNumber = rs.getString("PhoneNumber");
                Address = rs.getString("Address");
                Email = rs.getString("Email");
                roleId = rs.getInt("RoleID");
                role = rs.getString("RoleName");
                created_at = rs.getDate("Create_At");

                u = new User(id, userName, Age, PhoneNumber, Address, Email, roleId, created_at, role);
                users.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public User getUserByPhoneNumber(String phoneNumber) {
        String sql = "SELECT user_data.*, r.RoleName "
                + "FROM (SELECT * FROM Users WHERE PhoneNumber = ?) AS user_data "
                + "LEFT JOIN Roles r ON user_data.RoleID = r.RoleID;";
        int Age;
        int id;
        int roleId;
        String userName;
        String PhoneNumber;
        String Address;
        String Email;
        String role;
        String password;
        Date created_at;

        User u = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, phoneNumber);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("UserID");
                userName = rs.getString("UserName");
                Age = rs.getInt("Age");
                PhoneNumber = rs.getString("PhoneNumber");
                Address = rs.getString("Address");
                Email = rs.getString("Email");
                roleId = rs.getInt("RoleID");
                password = rs.getString("Password");
                role = rs.getString("RoleName");
                created_at = rs.getDate("Create_At");

                u = new User(id, userName, Age, PhoneNumber, password, Address, Email, roleId, created_at, role);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }


    public User getUserByID(int userID) {
        String sql = "SELECT user_data.*, r.RoleName "
                + "FROM (SELECT * FROM Users WHERE UserID = ?) AS user_data "
                + "LEFT JOIN Roles r ON user_data.RoleID = r.RoleID;";
        int Age;
        int id;
        int roleId;
        String userName;
        String PhoneNumber;
        String Address;
        String Email;
        String role;
        Date created_at;

        User u = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("UserID");
                userName = rs.getString("UserName");
                Age = rs.getInt("Age");
                PhoneNumber = rs.getString("PhoneNumber");
                Address = rs.getString("Address");
                Email = rs.getString("Email");
                roleId = rs.getInt("RoleID");
                role = rs.getString("RoleName");
                created_at = rs.getDate("Create_At");

                u = new User(id, userName, Age, PhoneNumber, Address, Email, roleId, created_at, role);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

}
