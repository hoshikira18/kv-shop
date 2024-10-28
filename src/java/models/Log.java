/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.*;

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

        File directory = new File(path);// folder to save log that newUser vist page
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File system = new File(path + "\\SystemSession");// folder to save log that running session of server
        if (!system.exists()) {
            system.mkdirs();
        }

        try {
            // Create a file handler to write log into the file
            FileHandler fileHandler = new FileHandler(path + "/" + fileName + ".txt", true); // Append to file
            fileHandler.setFormatter(new SimpleFormatter()); // Set log format
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

        File directory = new File(path);// folder to save log that newUser vist page
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
        //get newUser data
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

    public Log(String className, HttpServletRequest req, boolean isCreate, Cart cart, Cart_Item cart_Item) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get newUser data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String create = "";
        if (isCreate) {
            create = " đã tạo new Cart có CartID = " + cart.cartID + " và thêm item có ";
        } else {
            create = " đã thêm item vào Cart có CartID = " + cart.cartID + " và item có ";
        }
        String infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                + "\n" + u.getUserName() + create + cart_Item.itemID + " và proID = " + cart_Item.proID
                + " với số lượng = " + cart_Item.quantity;

        logger.info(infor);
        destroy();

    }

    public Log(String className, HttpServletRequest req, int proID, boolean isDelete) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get newUser data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);
        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String delete = "";
        if (isDelete) {
            delete = " đã xóa CartItem có proID = " + proID + "khỏi Cart";
        } else {
            delete = " đã cập nhật Cart";
        }
        String infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                + "\n" + u.getUserName() + delete;

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
        //get newUser data
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
        //get newUser data
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
        if (create) {
            infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                    + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName
                    + "\n" + u.getUserName() + " đã khởi tạo new Category có CategoryID là: " + category.getCategoryID()
                    + " và CategoryName là: " + category.getCategoryName();
        } else {
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
        //get newUser data
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
        //get newUser data
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

    public Log(String className, HttpServletRequest req, User newUser, boolean create) {
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
        if (create) {
            infor = "Người dùng tạo tài khoản thành công. UserPhone: " + newUser.getPhoneNumber()
                    + ", Email: " + newUser.getEmail() + ", UserName: " + newUser.getUserName() + ", Password: " + newUser.getPassword();
        } else {
            infor = "Người dùng tạo tài khoản không thành công. UserPhone: " + newUser.getPhoneNumber()
                    + ", Email: " + newUser.getEmail() + ", UserName: " + newUser.getUserName();
        }
        logger.info(infor);
        destroy();

    }

    public Log(String className, HttpServletRequest req, boolean isSuccess, User newUser) {
        //get data from req
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        // page name to write log by visit
        String fileName = list[list.length - 1].split("Servlet")[0];
        // page name to write log by sesstion
        String systemFile = (String) req.getSession().getAttribute("runningSession");
        //get newUser data
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        // create logger
        logger = Logger.getLogger(className);

        try {
            init(fileName, systemFile);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }

        String doing = "";
        if (fileName.toLowerCase().contains("create")) {
            doing = " đã tạo ";
        } else if (fileName.toLowerCase().contains("delete")) {
            doing = " đã xóa ";
        } else {
            doing = " đã chỉnh sửa ";
        }
        String infor;
        if (isSuccess) {
            infor = "Người dùng Admin có UserName = " + u.getUserName() + " và UserID = " 
                    + u.getUserID() + doing + "tài khoản thành công. Tài khoản mới có UserPhone: " + newUser.getPhoneNumber()
                    + ", Email: " + newUser.getEmail() + ", UserName: " + newUser.getUserName() + ", Password: " + newUser.getPassword();
        } else {
            infor = "Người dùng Admin có UserName = " + u.getUserName() + " và UserID = " 
                    + u.getUserID() + doing + "tài khoản không thành công. Tài khoản có UserPhone: " + newUser.getPhoneNumber()
                    + ", Email: " + newUser.getEmail() + ", UserName: " + newUser.getUserName();
        }
        logger.info(infor);
        destroy();

    }

}
