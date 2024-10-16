/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import models.Product;
import models.ProductDAO;
import java.util.logging.*;
import javax.imageio.ImageIO;
import models.Log;

/**
 *
 * @author VIET
 */
@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log log = new Log(this.getClass().getName(), req);

        PrintWriter out = resp.getWriter();

        ProductDAO pd = new ProductDAO();

        List<Product> list = pd.getTop(8);
        for (Product product : list) {

            File fileIn = new File("C:\\Users\\VIET\\OneDrive\\Hình ảnh\\AnhLamHTML\\hoaDao.jpg");
            byte[] image = new byte[(int) fileIn.length()];
            FileInputStream fis = new FileInputStream(fileIn);
            fis.read(image);
            String encode = Base64.getEncoder().encodeToString(image);
            ///////////
//                byte[] decode = Base64.getDecoder().decode(encode);
//                BufferedImage image1 = null;
//                ByteArrayInputStream bis = new ByteArrayInputStream(decode);
//                image1 = ImageIO.read(bis);
//                bis.close();
            product.setImage("data:image/jpeg;base64," + encode);
        }

        req.setAttribute("list", list);
//        req.getRequestDispatcher("/").forward(req, resp);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log log = new Log(this.getClass().getName(), req);

        PrintWriter out = resp.getWriter();

        ProductDAO pd = new ProductDAO();
        List<Product> list = pd.getTop(8);
//        for (Product product : list) {
//
//            File fileIn = new File("C:\\Users\\VIET\\OneDrive\\Hình ảnh\\AnhLamHTML\\hoaDao.jpg");
//            byte[] image = new byte[(int) fileIn.length()];
//            FileInputStream fis = new FileInputStream(fileIn);
//            fis.read(image);
//            String encode = Base64.getEncoder().encodeToString(image);
//            ///////////
////                byte[] decode = Base64.getDecoder().decode(encode);
////                BufferedImage image1 = null;
////                ByteArrayInputStream bis = new ByteArrayInputStream(decode);
////                image1 = ImageIO.read(bis);
////                bis.close();
//            product.setImage("data:image/jpeg;base64," + encode);
//        }

        req.setAttribute("list", list);

        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

}
