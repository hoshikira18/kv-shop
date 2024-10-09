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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author khuye
 */
@WebFilter(urlPatterns = {"/index.jsp"})
public class Auth implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        HttpServletResponse httpResponse = (HttpServletResponse) sr1;

        Cookie cookie = null;
        Cookie[] cookies = null;
        String username = "";
        cookies = httpRequest.getCookies();
        
        if (cookies == null) {
            httpResponse.sendRedirect("login.jsp");
        } 
        else {
            for (Cookie c : cookies) {
                if (c.getName().equals("email")) {
                    username = c.getValue();
                }
            }

            if (username.isEmpty()) {
                httpResponse.sendRedirect("login.jsp");
            }
        }

    }

    @Override
    public void destroy() {
    }

}
