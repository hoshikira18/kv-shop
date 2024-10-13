/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int roleID = Integer.parseInt(rs.getString("RoleID"));
                String roleName = rs.getString("RoleName");
                Date create_At = rs.getDate("Create_At");

                Role role = new Role(roleID, roleName, create_At);
                allRoles.add(role);
            }
            ps.close();
            rs.close();
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int roleID = Integer.parseInt(rs.getString("RoleID"));
                String roleName = rs.getString("RoleName");
                Date create_At = rs.getDate("Create_At");

                role = new Role(roleID, roleName, create_At);
                ps.close();
                rs.close();
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
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int roleID = Integer.parseInt(rs.getString("RoleID"));
                String roleName = rs.getString("RoleName");
                Date create_At = rs.getDate("Create_At");

                Role role = new Role(roleID, roleName, create_At);
                list.add(role);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Role role) {
        int id = role.getRoleID();
        xSql = "update Roles " + role.forUpdate() + " where RoleID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Role role) {
        xSql = "insert into Roles (RoleName)"
                + " values " + role.forInsert();
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
        xSql = "delete from Roles where RoleID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
