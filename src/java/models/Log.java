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

    private void init(String fileName) throws ServletException {
        String date = LocalDate.now().toString();

        // Get the real path relative to the web app root directory
        String relativePath = "/LOG/" + date; // Store logs in a "logs" directory


        File directory = new File(relativePath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create the directory if it doesn't exist
        }

        try {
            // Create a file handler to write log into the file
            FileHandler fileHandler = new FileHandler(relativePath + "/" + fileName + ".txt", true); // Append to file
            fileHandler.setFormatter(new SimpleFormatter()); // Set log format
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Disable logging to console
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
        String fileName = list[list.length - 1].split("Servlet")[0];

        UserDAO ud = new UserDAO();
        User u = ud.getUserByPhoneNumber(phone);
        logger = Logger.getLogger(className);
        try {
            init(fileName);
        } catch (ServletException ex) {
            Logger.getLogger(Log.class.getName()).log(Level.ALL, null, ex);
        }
        String infor = "Trang " + list[list.length - 1] + " đã được truy cập bởi: " + u.getUserName()
                + ", có ID: " + u.getUserID() + ", SĐT: " + u.getPhoneNumber() + ", Role: " + u.roleName;
        logger.info(infor);
        destroy();
    }

}
