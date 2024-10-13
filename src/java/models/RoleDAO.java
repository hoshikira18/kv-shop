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
public class RoleDAO extends MyDAO{
    public List<Role> getAllRoles() {
        List<Role> allRoles = new ArrayList<>();
        xSql = "select * from Roles";
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int roleID = Integer.parseInt(result.getString("roleID"));
                String roleName = result.getString("roleName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                Role role = new Role(roleID, roleName, create_At);
                allRoles.add(role);
            }
            connect.close();
            result.close();
            return allRoles;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allRoles;
    }

    public Role getOne(int id) {
        xSql = "select * from Roles where RoleID = " + id;
        Role role = new Role();
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int roleID = Integer.parseInt(result.getString("roleID"));
                String roleName = result.getString("roleName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                role = new Role(roleID, roleName, create_At);
                connect.close();
                result.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return role;
    }

    public List<Role> getList(String requirement) {
        List<Role> list = new ArrayList<>();
        xSql = "select * from Roles where " + requirement;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int roleID = Integer.parseInt(result.getString("roleID"));
                String roleName = result.getString("roleName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                Role role = new Role(roleID, roleName, create_At);
                list.add(role);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Role role) {
        int id = role.getRoleID();
        xSql = "update Roles " + role.forUpdate() + " where roleID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Role role) {
        xSql = "insert into Roles (roleName)"
                + " value " + role.forInsert();
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
        xSql = "delete from Roles where roleID = " + id;
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
