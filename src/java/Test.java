
import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.*;
import models.CategoryDAO;
import models.MyDAO;
import models.Product;
import models.ProductDAO;
import models.User;
import models.UserDAO;
import models.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/test"})
public class Test extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Test.class.getName());
    
    @Override
    public void init() throws ServletException {
        try {
            // Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler("Logging/Log.log", true); // true để append vào file
            fileHandler.setFormatter(new SimpleFormatter()); // Định dạng log
            logger.addHandler(fileHandler);
//            logger.setUseParentHandlers(false); // Tắt ghi log ra console
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String proID = (String) req.getAttribute("proID");
        out.print(proID);
        out.print("test link 123");

    }

    @Override
    public void destroy() {
        for (var handler : logger.getHandlers()) {
            handler.close();
        }
    }

}
