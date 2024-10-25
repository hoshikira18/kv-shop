/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import models.Cart_Item;
import models.Cart_ItemDAO;
import models.Product;
import models.User;
import models.UserDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/cart"})
public class ListCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("TEST SHOW CART");

//        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String phone = (String) req.getSession().getAttribute("phone");
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);

        out.println("TEST SHOW CART GET");

        out.println(u.getUserID() + "-" + u.getUserName() + "-" + u.getPhoneNumber());
        Cart_ItemDAO cid = new Cart_ItemDAO();
        List<String[]> listMain = cid.getListByUserID(u.getUserID());
        List<Product> listPro = new ArrayList<>();

// (Đừng xóa, đây là NOTE)String[6] bao gom:
// (int CartID, int ProID, String Pro_Name, String Image, int Quantity, double Price)
        String cartID = listMain.get(0)[0];
        double sum = 0;
        for (String[] record : listMain) {
            Product p = new Product(Integer.parseInt(record[1]), record[2],
                    record[3], Double.parseDouble(record[5]));
            listPro.add(p);
            /////////
            double value = Double.parseDouble(record[5]);
            record[5] = String.valueOf((int) value);
            ////////
            sum += (Integer.parseInt(record[4])) * (Double.parseDouble(record[5]));
//            out.println(record[1] + "-" + record[4] + "-" + record[5]);
        }
        String result = String.format("%.0f", sum);
//        sum = Integer.parseInt(String.format("%.3f", sum));
//        out.println("\nPRODUCTS\n");
//        out.printf("%.3f",sum);
//        out.println(sum);
//        out.println("\nAFTER SORT\n");

//        for (Product product : listPro) {
//            out.println(product.getProID() + "-" +product.getPrice());
//        }
//        
        req.setAttribute("userID", u.getUserID());
        req.setAttribute("cartID", cartID);
        req.setAttribute("listItem", listMain);
        req.setAttribute("listPro", listPro);
        req.setAttribute("sum", result);
        req.setAttribute("length", listMain.size());
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

}
