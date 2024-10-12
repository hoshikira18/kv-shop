/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import models.User;
import models.UserDAO;

/**
 *
 * @author khuye
 */
public class UserController {

    UserDAO ud = new UserDAO();

    public UserController() {
    }

    // login tra ve ma loi
    // 200 -> login thanh cong
    // 300 -> login khong thanh cong -> Tai khoan da ton tai
    // 400 -> login khong thanh cong -> sai password
    public int login(String phoneNumber, String password) {
        User u = ud.getUserByPhoneNumber(phoneNumber);
        if (u == null) {
            return 300;
        } else {
            if (password.equals(u.getPassword())) {
                return 200;
            } else {
                return 400;
            }
        }
    }

    public int createUser(User u) {
        User newUser = ud.createUser(u);

        if (newUser == null) {
            return 300;
        } else {
            return 200;
        }

    }

    public ArrayList<User> getAllUsers() {
        return ud.getAllUsers();
    }
    
    public User getUserByPhone (String phone) {
        return ud.getUserByPhoneNumber(phone);
    }

}
