package com.objectfrontier.training.webservices.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objectfrontier.training.webservices.model.Person;

public class AuthorizationFilter implements Filter {

    FilterConfig Config;
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        System.out.println("\n AuthorizationFilter");
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        boolean admin = (boolean) session.getAttribute("admin");
        Person person = (Person) session.getAttribute("person");
        chain.doFilter(request, response);
        if(admin == true) {
            chain.doFilter(request, response);
        }
        else if((req.getParameter("field").equalsIgnoreCase("update"))
               || (req.getParameter("field").equalsIgnoreCase("read"))) {

            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig Config) throws ServletException {
        // TODO Auto-generated method stub
        this.Config = Config;
    }

}
