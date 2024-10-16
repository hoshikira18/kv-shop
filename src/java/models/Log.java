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

    private void init(String fileName) throws ServletException {
        String date = LocalDate.now().toString();
        String path = "D:\\02.LearningDocument\\SE IV\\PRJ\\Assignment\\kv-shop\\Logging\\";
        path+=date;
        File directory = new File(path);
        if(!directory.exists()){
            directory.mkdirs();
        }
        
        try {
            // Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler(path + "\\" + fileName + ".txt", true); // true để append vào file
            fileHandler.setFormatter(new SimpleFormatter()); // Định dạng log
            logger.addHandler(fileHandler);
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
        String phone = (String) req.getSession().getAttribute("phone");
        String[] list = className.split("[.]");
        String fileName = list[list.length-1].split("Servlet")[0];
        
        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        logger = Logger.getLogger(className);
        try {
            init(fileName);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor = "Trang " + list[list.length-1] + " đã được truy cập bởi: " + u.getUserName() 
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName;
        logger.info(infor);
        destroy();
    }

}
