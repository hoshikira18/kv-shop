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

@WebFilter(urlPatterns = {"/login.jsp"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        HttpServletResponse httpResponse = (HttpServletResponse) sr1;

        HttpSession httpSession = httpRequest.getSession();
        httpSession.setMaxInactiveInterval(30 * 60); // 30 minutes session timeout

        int role;

        Object phoneObj = httpSession.getAttribute("phone");
        Object roleObj = httpSession.getAttribute("role");

        if (phoneObj != null) {
            role = (Integer) roleObj;
            // User is not authenticated, redirect to login page
            if (role == 1) {
                httpResponse.sendRedirect("/shop/admin/products.jsp");
            } else {
                httpResponse.sendRedirect("/shop/");
            }
        } else {
            // User is authenticated, allow request to proceed
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {
    }
}