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
import java.util.List;
import models.Cart_ItemDAO;
import models.Log;
import models.Product;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/checkOut"})
public class CheckOutServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Log log = new Log(this.getClass().getName(), req);
        ///// get information
        String pathInfo = req.getPathInfo();
        String userID = req.getParameter("userID");
        String cartID = req.getParameter("cartID");
        out.println(userID);

        String[] quantities = req.getParameterValues("quantity-input");
        String[] proIDs = req.getParameterValues("proID");
        String[] proSizes = req.getParameterValues("proSize");
        //// work with infor
        int length = quantities.length;
        String xSQL = "";
        for (int i = 0; i < length; i++) {
            xSQL += ("update Cart_Items set Quantity = "+quantities[i]
                    + " where CartID = " + cartID + " and ProID = " + proIDs[i] + " and ProSize = '" + proSizes[i] + "' \n");
        }
        Cart_ItemDAO cid = new Cart_ItemDAO();
        cid.update(xSQL);
        List<String[]> listMain = cid.getListByUserID(Integer.parseInt(userID));
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
        }
        String result = String.format("%.0f", sum);
        ////
        req.setAttribute("userID", userID);
        req.setAttribute("cartID", cartID);
        req.setAttribute("listItem", listMain);
        req.setAttribute("listPro", listPro);
        req.setAttribute("sum", result);
        req.setAttribute("length", listMain.size());
        req.getRequestDispatcher("checkOut.jsp").forward(req, resp);
        
    }
    
    
    
}
