/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author VIET
 */
public class User {

    int userID;
    String userName;
    int age;
    String phoneNumber;
    String address;
    String email;
    String password;
    int roleID;
    Date create_at;

    public User() {
    }

    public User(String userName, int age, String phoneNumber,
            String address, String email, String password, int roleID) {
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
    }

    public User(int userID, String userName, int age, String phoneNumber, String address, String email, String password, int roleID, Date create_at) {
        this.userID = userID;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.create_at = create_at;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String forUpdate() {
        String space = ", ";
        String string = "set userName = '" + userName + "'" + space + "age = " + age
                + space + "phoneNumber = '" + phoneNumber + "'" + space
                + "address = '" + address + "'" + space + "email = '"
                + email + "'" + space + "password = '" + password + "'"
                + space + "roleID = " + roleID;
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "('" + userName + "', " + age + ", '" + phoneNumber + "', '"
                + address + "', '" + email + "', '" + password + "', " + roleID + ")";
        return insert;
    }

}
