/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Cart_ItemDAO;
import models.Category;
import models.CategoryDAO;
import models.Log;
import models.Order;
import models.OrderDAO;
import models.Product;
import models.ProductDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/createOrder"})
public class CreateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ///// get information
        String userID = req.getParameter("userID");
        String cartID = req.getParameter("cartID");
        double sum = Double.parseDouble(req.getParameter("sum"));
        String payMethod = req.getParameter("payOption");
        
        //// work with infor
        OrderDAO od = new OrderDAO();
        od.insert(new Order(Integer.parseInt(userID), sum, payMethod));
        Order newOrder = od.getNewestOfUser(Integer.parseInt(userID));
        String xSQL1 = "insert into Order_Items (OrderID, ProID, Quantity)"
                + " select " + newOrder.getOrderID() + ", c.ProID, "
                + "c.Quantity from Cart_Items c where c.CartID = " + cartID 
                + "\ndelete Cart_Items where CartID = " + cartID;

        Cart_ItemDAO cid = new Cart_ItemDAO();
        cid.update(xSQL1);
        Log log = new Log(this.getClass().getName(), req, newOrder);
        
//        List<String[]> listMain = cid.getListByUserID(Integer.parseInt(userID));
//        List<Product> listPro = new ArrayList<>();
// (Đừng xóa, đây là NOTE)String[6] bao gom:
// (int CartID, int ProID, String Pro_Name, String Image, int Quantity, double Price)
//        double sum = 0;
//        for (String[] record : listMain) {
//            Product p = new Product(Integer.parseInt(record[1]), record[2],
//                    record[3], Double.parseDouble(record[5]));
//            listPro.add(p);
//            /////////
//            double value = Double.parseDouble(record[5]);
//            record[5] = String.valueOf((int) value);
//            ////////
//            sum += (Integer.parseInt(record[4])) * (Double.parseDouble(record[5]));
//        }
        
        
        req.getRequestDispatcher("alertOrderSuccess.jsp").forward(req, resp);
    }

}
