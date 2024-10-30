/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cart;

import controller.ProductDetail;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import models.Cart;
import models.CartDAO;
import models.Cart_Item;
import models.Cart_ItemDAO;
import models.Category;
import models.CategoryDAO;
import models.Log;
import models.Product;
import models.ProductDAO;
import models.User;
import models.UserDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/addToCarts"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        int proID = Integer.parseInt((String) req.getParameter("proID"));
        String from = (String) req.getParameter("from");

        ProductDAO pd = new ProductDAO();
        Product p = pd.getOne(proID);

        String phone = (String) req.getSession().getAttribute("phone");
        UserDAO ud = new UserDAO();
        User user = ud.getUserByPhoneNumber(phone);

        CartDAO cd = new CartDAO();
        Cart cart = cd.getCartByUser(user.getUserID());
        boolean isCreate = false;
        if (cart.getCartID() == 0) {
            cart = new Cart(user.getUserID(), 0);
            cd.insert(cart);
            isCreate = true;
        }
        cart = cd.getCartByUser(user.getUserID());

        int quantitty = 1;
        String proSize = "M";
        if (from.equals("detail")) {
            quantitty = Integer.parseInt(req.getParameter("quantity"));
            proSize = req.getParameter("size");
        }
        out.print("quantity: "+quantitty);
        out.println("\nSize: "+proSize);
        Cart_Item cart_Item = new Cart_Item(cart.getCartID(), p.getProID(), quantitty, proSize);
        out.println(cart_Item.forInsert());
        Cart_ItemDAO cid = new Cart_ItemDAO();
        cid.insert(cart_Item);
        cart_Item = cid.getNewest();
        out.println("lan 2: size:"+cart_Item.getProSize());
        out.println(cart_Item.forInsert());

        Log log = new Log(this.getClass().getName(), req, isCreate, cart, cart_Item);

        if (from.equals("home")) {
            CategoryDAO cc = new CategoryDAO();
            List<Category> listCate = cc.getAllCategories();

            List<Product> list = pd.getTop(8, "asc");
            List<Product> list2 = pd.getTop(8, "desc");

            req.setAttribute("list2", list2);
            req.setAttribute("list", list);
            req.setAttribute("listCate", listCate);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else if (from.equals("shop")) {
            List<Product> allProducts = new ArrayList<>();
            CategoryDAO cc = new CategoryDAO();
            List<Category> listCate = cc.getAllCategories();

            int loadCount = 1;
            allProducts = new ProductDAO().getAllProducts();
            List<Product> allProductsDown = new ProductDAO().getAllProductsDown();
            List<Product> list2 = pd.getTop(8, "desc");

            req.setAttribute("list2", list2);

            req.setAttribute("loadCount", loadCount);
            req.setAttribute("allProducts", allProducts);
            req.getRequestDispatcher("products.jsp").forward(req, resp);
        } else if (from.equals("detail")) {
//            req.setAttribute("product", p);
//            req.getRequestDispatcher("./product/product-detail.jsp").forward(req, resp);

            List<Product> relatedProducts = new ProductDAO().getProductsByCategory(cart.getCartID());
            req.setAttribute("product", p);
            req.setAttribute("relatedProducts", relatedProducts);
            resp.sendRedirect("./products/" + proID);
//        req.getRequestDispatcher("./product/product-detail.jsp").forward(req, resp);

        }
//        req.setAttribute("product", p);
//        req.getRequestDispatcher("/home.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int proID = Integer.parseInt((String) req.getParameter("proID"));
        String from = (String) req.getParameter("from");

        ProductDAO pd = new ProductDAO();
        Product p = pd.getOne(proID);

        String phone = (String) req.getSession().getAttribute("phone");
        UserDAO ud = new UserDAO();
        User user = ud.getUserByPhoneNumber(phone);

        CartDAO cd = new CartDAO();
        Cart cart = cd.getCartByUser(user.getUserID());
        boolean isCreate = false;
        if (cart.getCartID() == 0) {
            cart = new Cart(user.getUserID(), 0);
            cd.insert(cart);
            isCreate = true;
        }
        cart = cd.getCartByUser(user.getUserID());
        int quantity = 1;
        String proSize = "M";
        if (from.equals("detail")) {
            quantity = Integer.parseInt(req.getParameter("quantity"));
            proSize = req.getParameter("size");
        }

        Cart_Item cart_Item = new Cart_Item(cart.getCartID(), p.getProID(), quantity, proSize);
        Cart_ItemDAO cid = new Cart_ItemDAO();
        cid.insert(cart_Item);
        cart_Item = cid.getNewest();

        Log log = new Log(this.getClass().getName(), req, isCreate, cart, cart_Item);

        req.setAttribute("id", proID);
//            Product product = new ProductDAO().getOne(proID);
        List<Product> relatedProducts = new ProductDAO().getProductsByCategory(11);
        req.setAttribute("product", p);
        req.setAttribute("relatedProducts", relatedProducts);
        req.getRequestDispatcher("./product/product-details.jsp").forward(req, resp);

    }
}
