package com.example.productshop.security;

import com.example.productshop.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName = "LoginFilter")
//@Scope("session")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");

        if (((HttpServletRequest) req).getRequestURI().contains("login"))
        {
            chain.doFilter(req,resp);
            return;
        }
        if (user!=null)
        {
            chain.doFilter(req,resp);
            return;
        }
        if (((HttpServletRequest) req).getRequestURI().contains("register"))
        {
            chain.doFilter(req,resp);
            return;
        }
        else
        {
            response.sendRedirect("login");
        }
        System.out.println("Merhaba");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
