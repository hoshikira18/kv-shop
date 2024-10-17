/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.HomeServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.logging.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author VIET
 */
public class Log {

    private static Logger logger;

    private void init(String fileName, String systemFile) throws ServletException {
        String date = LocalDate.now().toString();
        String path = "D:\\02.LearningDocument\\SE IV\\PRJ\\Assignment\\kv-shop\\Logging\\";
        path += date;//folder day by day

        File directory = new File(path);// folder to save log that user vist page
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File system = new File(path + "\\SystemSession");// folder to save log that running session of server
        if (!system.exists()) {
            system.mkdirs();
        }

        try {
            // Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler(path + "\\" + fileName + ".txt", true); // true để append vào file
            fileHandler.setFormatter(new SimpleFormatter()); // Định dạng log
            logger.addHandler(fileHandler);
            // Tạo hander để ghi vào file system
            FileHandler fileHandlerSystem = new FileHandler(path + "\\SystemSession\\" + systemFile + ".txt", true);
            fileHandlerSystem.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandlerSystem);
            ///
            logger.setUseParentHandlers(false); // Tắt ghi log ra console
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }
    private void init(String fileName) throws ServletException {
        String date = LocalDate.now().toString();
        String path = "D:\\02.LearningDocument\\SE IV\\PRJ\\Assignment\\kv-shop\\Logging\\";
        path += date;//folder day by day

        File directory = new File(path);// folder to save log that user vist page
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler(path + "\\" + fileName + ".txt", true); // true để append vào file
            fileHandler.setFormatter(new SimpleFormatter()); // Định dạng log
            logger.addHandler(fileHandler);
            ///
            logger.setUseParentHandlers(false); // Tắt ghi log ra console
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    private void destroy() {
        // Đóng các handler khi servlet bị hủy
        for (var handler : logger.getHandlers()) {
            handler.close();
        }
    }

    public Log(String className, HttpServletRequest req) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get user data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName;
        logger.info(infor);
        destroy();

    }

    public Log(String className, HttpServletRequest req, Product product, int categoryID) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get user data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);

        Category cate = new CategoryDAO().getOne(categoryID);

        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                + "\n" + u.getUserName() + " đã khởi tạo new Product có ProID là: " + product.getProID()
                + " và ProName là: " + product.getProName() + " thuộc Category: " + cate.categoryName
                + " có CategoryID là: " + cate.getCategoryID();
        logger.info(infor);
        destroy();

    }

    public Log(String className, HttpServletRequest req, Category category, boolean create) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get user data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor;
        if(create){
        infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                + "\n" + u.getUserName() + " đã khởi tạo new Category có CategoryID là: " + category.getCategoryID()
                + " và CategoryName là: " + category.getCategoryName();
        }else{
            infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                + "\n" + u.getUserName() + " đã xóa Category có CategoryID là: " + category.getCategoryID()
                + " và CategoryName là: " + category.getCategoryName();
        }
        logger.info(infor);
        destroy();

    }

    public Log(String className, HttpServletRequest req, int proID) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get user data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);

        Product p = new ProductDAO().getOne(proID);

        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                + "\n" + u.getUserName() + " đã xem hàng có ID: " + p.getProID() + " và proName: " + p.getProName();
        logger.info(infor);
        destroy();

    }

    public Log(String className, String phone, String password, String systemFile, boolean enter) {
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        //get user data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor = "";
        if (enter) {
            infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                    + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName;
        } else {
            infor = "Có người dùng đăng nhập sai thông tin: Phone: " + phone + ", password: " + password;
        }
        logger.info(infor);
        destroy();

    }
    
    public Log(String className, HttpServletRequest req, User user, boolean create) {
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = "SignUp";
        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor;
        if(create){
        infor = "Người dùng tạo tài khoản thành công. UserPhone: "+user.getPhoneNumber()
                +", Email: "+ user.getEmail() +", UserName: "+user.getUserName()+", Password: "+user.getPassword();
        }else{
            infor = "Người dùng tạo tài khoản không thành công. UserPhone: "+user.getPhoneNumber()
                +", Email: "+ user.getEmail() +", UserName: "+user.getUserName();
        }
        logger.info(infor);
        destroy();

    }

}
