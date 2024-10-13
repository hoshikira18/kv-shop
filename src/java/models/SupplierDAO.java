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
public class SupplierDAO extends MyDAO{
    public List<Supplier> getAllSuppliers() {
        List<Supplier> allSuppliers = new ArrayList<>();
        xSql = "select * from Suppliers";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int supplierID = Integer.parseInt(rs.getString("SupplierID"));
                String supplierName = rs.getString("SupplierName");
                Date create_At = rs.getDate("Create_At");

                Supplier supplier = new Supplier(supplierID, supplierName, create_At);
                allSuppliers.add(supplier);
            }
            ps.close();
            rs.close();
            return allSuppliers;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allSuppliers;
    }

    public Supplier getOne(int id) {
        xSql = "select * from Suppliers where SupplierID = " + id;
        Supplier supplier = new Supplier();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int supplierID = Integer.parseInt(rs.getString("SupplierID"));
                String supplierName = rs.getString("SupplierName");
                Date create_At = rs.getDate("Create_At");

                supplier = new Supplier(supplierID, supplierName, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return supplier;
    }

    public List<Supplier> getList(String requirement) {
        List<Supplier> list = new ArrayList<>();
        xSql = "select * from Suppliers where " + requirement;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int supplierID = Integer.parseInt(rs.getString("SupplierID"));
                String supplierName = rs.getString("SupplierName");
                Date create_At = rs.getDate("Create_At");

                Supplier supplier = new Supplier(supplierID, supplierName, create_At);
                list.add(supplier);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Supplier supplier) {
        int id = supplier.getSupplierID();
        xSql = "update Suppliers " + supplier.forUpdate() + " where SupplierID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Supplier supplier) {
        xSql = "insert into Suppliers (SupplierName)"
                + " values " + supplier.forInsert();
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
        xSql = "delete from Suppliers where SupplierID = " + id;
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
