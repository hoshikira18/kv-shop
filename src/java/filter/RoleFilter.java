/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author khuye
 */
@WebFilter(urlPatterns = ("/admin/*"))
public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        HttpServletResponse httpResponse = (HttpServletResponse) sr1;
        
        PrintWriter out = httpResponse.getWriter();

        HttpSession httpSession = httpRequest.getSession();
        httpSession.setMaxInactiveInterval(30 * 60); // 30 minutes session timeout

        int role;

        Object roleObj = httpSession.getAttribute("role");
        role = (Integer) roleObj;
        
        // check role la admin hay customer
        if (roleObj != null && role != 1) {
            httpResponse.sendRedirect("/shop/");
        } else {
            fc.doFilter(sr, sr1);
        }

    }

    @Override
    public void destroy() {
    }

}
