package com.objectfrontier.training.webservices.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;
import com.objectfrontier.training.webservices.pojo.Address;
import com.objectfrontier.training.webservices.service.AddressService;
import com.objectfrontier.training.webservices.service.AppException;
import com.objectfrontier.training.webservices.test.JsonConverter;

public class AddressServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    AddressService addressService;
    Connection con;
    ConnectionManagement management;

    @Override
    public void init() {
        addressService = new AddressService();
        management = new ConnectionManagement();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
//        out.println(con);
        try {
            con = management.getConnection();
            con.setAutoCommit(false);
            if ("read".equalsIgnoreCase(req.getParameter("field"))){
                long id = Long.parseLong(req.getParameter("id"));
                Address address = addressService.read(con, id);
                management.release(con, true);
                res.setStatus(HttpServletResponse.SC_OK);
                out.write(JsonConverter.toJson(address));
            } else if ("readall".equalsIgnoreCase(req.getParameter("field"))) {
                List <Address> allPerson = addressService.readAll(con);
                management.release(con, true);
                out.println(JsonConverter.toJson(allPerson));
            }
        } catch (Exception e) {
            management.release(con, true);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
            }
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        try {
            con = management.getConnection();
            con.setAutoCommit(false);
            BufferedReader reader = req.getReader();
            List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
            String addressJson = String.join("", jsonLines); //or use readLine() Method with while block
            System.out.format("Input JSON >> %s", addressJson);
            //Converting JSON to Object
            Address input = JsonConverter.toObject(addressJson, Address.class);
            if ("create".equalsIgnoreCase(req.getParameter("field"))){
                //call address service
                Address address =addressService.create(con,input);
                resp.setStatus(HttpServletResponse.SC_OK);
                management.release(con, true);
                out.write(JsonConverter.toJson(address));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            management.release(con, false);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
            }
        }
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        try {
            con = management.getConnection();
            con.setAutoCommit(false);
            BufferedReader reader = req.getReader();
            List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
            String addressJson = String.join("", jsonLines); //or use readLine() Method with while block
            System.out.format("Input JSON >> %s", addressJson);
            //Converting JSON to Object
            Address input = JsonConverter.toObject(addressJson, Address.class);
            if ("update".equalsIgnoreCase(req.getParameter("field"))) {
                if (addressService.update(con,input)){
                    management.release(con, true);
                    out.println(JsonConverter.toJson(input));
                }
            } else if ("delete".equalsIgnoreCase(req.getParameter("field"))) {
                if (addressService.delete(con,input)){
                    management.release(con, true);
                    out.println(JsonConverter.toJson(input));
                }
            }
        } catch (Exception e) {
            management.release(con, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
            }
        }
    }
}
