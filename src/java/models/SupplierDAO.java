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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int supplierID = Integer.parseInt(result.getString("supplierID"));
                String supplierName = result.getString("supplierName");
                Date create_At = result.getDate("create_At");

                Supplier supplier = new Supplier(supplierID, supplierName, create_At);
                allSuppliers.add(supplier);
            }
            connect.close();
            result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            if (result.next()) {
                int supplierID = Integer.parseInt(result.getString("supplierID"));
                String supplierName = result.getString("supplierName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                supplier = new Supplier(supplierID, supplierName, create_At);
                connect.close();
                result.close();
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
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();
            while (result.next()) {
                int supplierID = Integer.parseInt(result.getString("supplierID"));
                String supplierName = result.getString("supplierName");
                Date create_At = Date.valueOf(result.getString("create_At"));

                Supplier supplier = new Supplier(supplierID, supplierName, create_At);
                list.add(supplier);
            }
            connect.close();
            result.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Supplier supplier) {
        int id = supplier.getSupplierID();
        xSql = "update Suppliers " + supplier.forUpdate() + " where supplierID = " + id;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Supplier supplier) {
        xSql = "insert into Suppliers (supplierName)"
                + " value " + supplier.forInsert();
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
        xSql = "delete from Suppliers where supplierID = " + id;
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
