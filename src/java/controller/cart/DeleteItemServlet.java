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
import models.Cart_ItemDAO;
import models.Log;
import models.Product;
import models.User;
import models.UserDAO;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/deleteItem"})
public class DeleteItemServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.println("DO POST" + req.getRequestURI());
        String test = req.getParameter("id");
        out.println(test);
//        String phone = (String) req.getSession().getAttribute("phone");
//        UserDAO ud = new UserDAO();
//        User u = ud.getUserByPhoneNumber(phone);
//
//        
//        out.println(u.getUserID() + "-" + u.getUserName() + "-" + u.getPhoneNumber());
//        Cart_ItemDAO cid = new Cart_ItemDAO();
//        List<String[]> listMain = cid.getListByUserID(u.getUserID());
//        List<Product> listPro = new ArrayList<>();
//
//// (Đừng xóa, đây là NOTE)String[6] bao gom:
//// (int CartID, int ProID, String Pro_Name, String Image, int Quantity, double Price)
//        String cartID = listMain.get(0)[0];
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
////            out.println(record[1] + "-" + record[4] + "-" + record[5]);
//        }
//        String result = String.format("%.0f", sum);
//        req.setAttribute("userID", u.getUserID());
//        req.setAttribute("cartID", cartID);
//        req.setAttribute("listItem", listMain);
//        req.setAttribute("listPro", listPro);
//        req.setAttribute("sum", result);
//        req.setAttribute("length", listMain.size());
//        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.println("DO GET" + req.getRequestURI());
        String proID = req.getParameter("id");
        String cartID = req.getParameter("cartID");
        String phone = (String) req.getSession().getAttribute("phone");
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        
        Cart_ItemDAO cid = new Cart_ItemDAO();
        // delete (int cartID, int proID)
        cid.delete(u.getUserID(), Integer.parseInt(proID));
        Log log = new Log(this.getClass().getName(), req, Integer.parseInt(proID), true);
        
//        out.println(u.getUserID() + "-" + u.getUserName() + "-" + u.getPhoneNumber());
        
        List<String[]> listMain = cid.getListByUserID(u.getUserID());
        List<Product> listPro = new ArrayList<>();

// (Đừng xóa, đây là NOTE)String[6] bao gom:
// (int CartID, int ProID, String Pro_Name, String Image, int Quantity, double Price)
        
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
        req.setAttribute("userID", u.getUserID());
        req.setAttribute("cartID", cartID);
        req.setAttribute("listItem", listMain);
        req.setAttribute("listPro", listPro);
        req.setAttribute("sum", result);
        req.setAttribute("length", listMain.size());
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
    
}
