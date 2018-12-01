package com.objectfrontier.training.webservices.filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;

public class TransactionFilter implements Filter {

    ConnectionManagement connectionManager;
    FilterConfig Config;
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

     // Request to server
        System.out.println("Request -> Transaction Filter begins >>");
        connectionManager.getConn();
        Connection connection = ConnectionManagement.myThreadLocal.get();
        try {
            // calling the next filter in the chain
            chain.doFilter(request, response);
            connectionManager.release(connection, true);
        } catch (Exception e) {
            connectionManager.release(connection, false);
            throw e;
        }
    }

    @Override
    public void init(FilterConfig Config) throws ServletException {

        connectionManager = new ConnectionManagement();
        this.Config = Config;
    }

}
