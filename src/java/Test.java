
import controller.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.MyDAO;
import models.User;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        UserController userController = new UserController();
        int loginStatus = userController.login("0345812123213139", "1235");

        switch (loginStatus) {
            case 200 ->
                out.print("Dang nhap thanh cong!");
            case 300 ->
                out.print("Tai khoan khong ton tai!");
            case 400 ->
                out.print("Sai mat khau!");
            default -> {
            }
        }

    }

}
