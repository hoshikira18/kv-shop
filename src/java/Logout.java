
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import models.Log;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author khuye
 */
@WebServlet(urlPatterns = {"/logout"})
public class Logout extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log log = new Log(this.getClass().getName(), req);
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("phone");
        httpSession.removeAttribute("role");
        resp.sendRedirect("login.jsp");
    }
    
}
