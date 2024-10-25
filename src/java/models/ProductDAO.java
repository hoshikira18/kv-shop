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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VIET
 */
public class ProductDAO extends MyDAO {

    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        xSql = """
               select 
               p.*,
               s.SupplierName as supName, 
               c.CategoryName as cateName,
               c.CategoryID as cateID
               from Products p join Suppliers s on p.SupID = s.SupplierID join ProductCategories pc on p.ProID = pc.ProID join Categories c on pc.CategoryID = c.CategoryID""";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ProID");
                String productName = rs.getString("Pro_Name");
                String supName = rs.getString("supName");
                String cateName = rs.getString("cateName");
                int cateID = rs.getInt("cateID");
                String size = rs.getString("Size");
                String description = rs.getString("Description");

                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = rs.getDouble("Price");
                int supID = rs.getInt("SupID");
                int inventory = rs.getInt("Inventory");

                Product product = new Product(ID, productName, image, price, supID, cateID, inventory, size, description, supName, cateName);
                allProducts.add(product);
            }
            ps.close();
            rs.close();
            return allProducts;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allProducts;
    }

    public List<Product> getProductsByCategory(int categoryID) {
        List<Product> products = new ArrayList<>();
        xSql = "select * from Products where ProID in (select ProID from ProductCategories where CategoryID = " + categoryID + ")";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = rs.getInt("SupID");
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
                products.add(product);
            }
            ps.close();
            rs.close();
            return products;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return products;

    }

    public List<Product> getAllProductsDown() {
        List<Product> allProducts = new ArrayList<>();
        xSql = "select * from Products order by create_At desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
                allProducts.add(product);
            }
            ps.close();
            rs.close();
            return allProducts;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allProducts;
    }

    public Product getOne(int id) {
        xSql = """
               select 
               p.*,
               s.SupplierName as supName, 
               c.CategoryName as cateName,
               c.CategoryID as cateID
               from (select * from Products where ProID = """ + id + ") p join Suppliers s on p.SupID = s.SupplierID join ProductCategories pc on p.ProID = pc.ProID join Categories c on pc.CategoryID = c.CategoryID";

        Product product = new Product();
        try {

            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ProID");
                String productName = rs.getString("Pro_Name");
                String supName = rs.getString("supName");
                String cateName = rs.getString("cateName");
                int cateID = rs.getInt("cateID");
                String size = rs.getString("Size");
                String description = rs.getString("Description");

                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = rs.getDouble("Price");
                int supID = rs.getInt("SupID");
                int inventory = rs.getInt("Inventory");

                product = new Product(ID, productName, image, price, supID, cateID,inventory, size, description, supName, cateName);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }

    public List<Product> getList(String requirement) {
        List<Product> list = new ArrayList<>();
        xSql = "select * from Products where " + requirement;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getTop(int n, String ascOrDesc) {
        List<Product> list = new ArrayList<>();
        xSql = "select top " + n + " * from Products order by ProID " + ascOrDesc;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                Product product = new Product(ID, productName, image, price, supID, inventory, create_At);
                list.add(product);
            }
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(Product product) {
        int id = product.getProID();

        xSql = "update Products " + product.forUpdate() + " where ProID = " + id;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Product insert(Product product) {
        xSql = "insert into Products (Pro_Name, Image, Price, SupID, Inventory, Size, Description)"
                + " values " + product.forInsert();

        Product p = null;
        try {
            PreparedStatement connect = connection.prepareStatement(xSql);
            ResultSet result = connect.executeQuery();

            connect.close();
            result.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        p = getNewestProduct();

        return p;
    }

    public Product getNewestProduct() {
        xSql = "select top(1) * from Products order by Create_At desc";
        Product product = null;

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            if (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("Image");
                double price = Double.parseDouble(rs.getString("Price"));
                int supID = Integer.parseInt(rs.getString("SupID"));
                int inventory = Integer.parseInt(rs.getString("Inventory"));
                Date create_At = rs.getDate("Create_At");

                product = new Product(ID, productName, image, price, supID, inventory);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return product;
    }

    public void delete(int id) {
        xSql = "delete from Cart_Items where ProID = " + id + ";delete from ProductCategories where ProID = " + id + ";delete from Products where ProID = " + id;
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List[] getSameCategory(int proID) {
        List[] list = new ArrayList[3];
//        list[0] là listProducts, list[1] là listSuppliers, list[2] là Category
        xSql = """
               select p.ProID, p.Pro_Name, p.Price, p.Size, p.Description, p.Image as ProImage,s.SupplierID
               , s.SupplierName, c.CategoryID, c.CategoryName, c.Image as CateImage
               from (
               \tselect top 1 c.CategoryID
               \tfrom Products p
               \tjoin Suppliers s on s.SupplierID = p.SupID
               \tjoin ProductCategories pc on p.ProID = pc.ProID
               \tjoin Categories c on pc.CategoryID = c.CategoryID
               \twhere p.ProID = ?
               ) as cateID, Products p
               join Suppliers s on s.SupplierID = p.SupID
               join ProductCategories pc on p.ProID = pc.ProID
               join Categories c on pc.CategoryID = c.CategoryID
               where pc.CategoryID =  cateID.CategoryID""";
        
        Product p = null;
        Supplier s = null;
        Category c = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(xSql);
            ps.setString(1, String.valueOf(proID));
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = Integer.parseInt(rs.getString("ProID"));
                String productName = rs.getString("Pro_Name");
                String image = "data:image/jpeg;base64," + rs.getString("ProImage");
                double price = Double.parseDouble(rs.getString("Price"));
                String size = rs.getString("Size");
                String description =  rs.getString("Description");
                
                
                int supID = Integer.parseInt(rs.getString("SupID"));
                String supplierName = rs.getString("SupplierName");
                
                int categoryID = Integer.parseInt(rs.getString("categoryID"));
                String categoryName = rs.getString("CategoryName");
                String cateImage = "data:image/jpeg;base64," + rs.getString("CateImage");
                
                //product
                p = new Product(proID, productName, image, price, supID, size, description);
                list[0].add(p);
                //supplier
                s = new Supplier(supID, supplierName);
                list[1].add(s);
                //category -- chỉ có 1 cate nên để đó add sau khi vòng lặp kết thúc
                c = new Category(categoryID, categoryName, cateImage);
            }
            list[2].add(c);
            ps.close();
            rs.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
}
