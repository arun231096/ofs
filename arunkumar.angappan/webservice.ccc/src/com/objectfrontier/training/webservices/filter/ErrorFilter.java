package com.objectfrontier.training.webservices.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.test.JsonConverter;

public class ErrorFilter implements Filter {

    FilterConfig Config;
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        PrintWriter out = res.getWriter();
        // Request to server
        System.out.println("Request -> Error Filter begins >>");
        // calling the next filter in the chain
        try {
        chain.doFilter(request, response);
        res.setStatus(HttpStatus.SC_OK);
        } catch (Exception e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
            } else {
                log(e.getMessage());
            }
        }
        System.out.println("Response <- Error Filter ends <<");
    }

    private void log(String message) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(FilterConfig Config) throws ServletException {

        this.Config = Config;
    }

}
