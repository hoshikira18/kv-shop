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
public class Cart_ItemDAO extends MyDAO {

    public List<Cart_Item> getAllCart_Items() {
        List<Cart_Item> allCart_Items = new ArrayList<>();
        xSql = "select * from Cart_Items";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                Cart_Item cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                allCart_Items.add(cart_Item);
            }
            ps.close();
            rs.close();
            return allCart_Items;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allCart_Items;
    }

    public Cart_Item getOne(int id) {
        xSql = "select * from Cart_Items where itemID = " + id;
        Cart_Item cart_Item = new Cart_Item();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart_Item;
    }

    public Cart_Item getNewest() {
        xSql = "select top 1 * from Cart_Items order by create_At desc";
        Cart_Item cart_Item = new Cart_Item();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                ps.close();
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cart_Item;
    }

    public List<String[]> getListByUserID(int userID) {
        List[] listMain = new List[2];
        List<String[]> list = new ArrayList<>();
        List<Cart_Item> listItems = new ArrayList<>();
        List<Product> listProducts = new ArrayList<>();
        xSql = "select CI.ItemID, CartID.CartID, P.ProID, P.Pro_Name, P.Image, Quantity, P.Price \n"
                + "from (select CartID from Carts where UserID = ?) as CartID, Cart_Items CI \n"
                + "join Products P on CI.ProID = P.ProID \n"
                + "where CartID.CartID = CI.CartID order by ProID asc";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, String.valueOf(userID));
            rs = ps.executeQuery();
            while (rs.next()) {
                String[] record = new String[6];
                record[0] = rs.getString("CartID");
                record[1] = rs.getString("ProID");
                record[2] = rs.getString("Pro_Name");
                record[3] = "data:image/jpeg;base64," + rs.getString("Image");
                record[4] = rs.getString("Quantity");
                record[5] = rs.getString("Price");
///////                
/// --(int CartID, int ProID, String Pro_Name, String Image, int Quantity, double Price)--
//////                
                list.add(record);
            }
            ps.close();
            rs.close();
            listMain[0] = listItems;
            listMain[1] = listProducts;
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Cart_Item> getList(String requirement) {
        List<Cart_Item> list = new ArrayList<>();
        xSql = "select * from Cart_Items where " + requirement;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int itemID = Integer.parseInt(rs.getString("ItemID"));
                int cartID = Integer.parseInt(rs.getString("CartID"));
                int proID = Integer.parseInt(rs.getString("ProID"));
                int quantity = Integer.parseInt(rs.getString("Quantity"));
                Date create_At = rs.getDate("Create_At");

                Cart_Item cart_Item = new Cart_Item(itemID, cartID, proID, quantity, create_At);
                list.add(cart_Item);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Cart_Item cart_Item) {
        int id = cart_Item.getItemID();
        xSql = "update Cart_Items " + cart_Item.forUpdate() + " where ItemID = " + id;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(Cart_Item cart_Item) {
        xSql = "insert into Cart_Items (CartID, ProID, Quantity)"
                + " values " + cart_Item.forInsert();
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
        xSql = "delete from Cart_Items where ItemID = " + id;
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
