/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author khuye
 */
public class UserDAO extends MyDAO {

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
