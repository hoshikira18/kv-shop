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
public class Role {
    int roleID;
    String roleName;
    Date create_at;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int roleID, String roleName, Date create_at) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.create_at = create_at;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
    public String forUpdate() {
        String space = ", ";
        String string = "set RoleName = '" + roleName + "'";
        return string;
    }

    public String forInsert() {
        String insert = "";
        insert = "('" + roleName+ "')";
        return insert;
    }
    
}
