package com.objectfrontier.training.webservices.servlet.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;
import com.objectfrontier.training.webservices.model.Address;
import com.objectfrontier.training.webservices.service.business.AddressService;
import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.service.business.ErrorCodes;
import com.objectfrontier.training.webservices.test.JsonConverter;

public class AddressServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    AddressService addressService;

    @Override
    public void init() {
        addressService = new AddressService();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        try {
            Connection con = ConnectionManagement.myThreadLocal.get();
            con.setAutoCommit(false);
            if ("read".equalsIgnoreCase(req.getParameter("field"))){
                long id = Long.parseLong(req.getParameter("id"));
                Address address = addressService.read(con, id);
                res.setStatus(HttpServletResponse.SC_OK);
                out.write(JsonConverter.toJson(address));
            } else if ("readall".equalsIgnoreCase(req.getParameter("field"))) {
                List <Address> allPerson = addressService.readAll(con);
                out.println(JsonConverter.toJson(allPerson));
            }
        } catch (SQLException e) {
            log(e.getMessage());
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        Connection con =  ConnectionManagement.myThreadLocal.get();
        BufferedReader reader = req.getReader();
        String addressJson = convertToObject(reader);
        System.out.format("Input JSON >> %s", addressJson);
        //Converting JSON to Object
        Address input = JsonConverter.toObject(addressJson, Address.class);
        if ("create".equalsIgnoreCase(req.getParameter("field"))){
            //call address service
            Address address;
            try {
                address = addressService.create(con,input);
                resp.setStatus(HttpServletResponse.SC_OK);
                out.write(JsonConverter.toJson(address));
            } catch (SQLException e) {
                log(e.getMessage());
                throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        try {
            Connection con =  ConnectionManagement.myThreadLocal.get();
            BufferedReader reader = req.getReader();
            String addressJson = convertToObject(reader); //or use readLine() Method with while block
            System.out.format("Input JSON >> %s", addressJson);
            //Converting JSON to Object
            Address input = JsonConverter.toObject(addressJson, Address.class);
            if ("update".equalsIgnoreCase(req.getParameter("field"))) {
                if (addressService.update(con,input)){
                    out.println(JsonConverter.toJson(input));
                }
            } else if ("delete".equalsIgnoreCase(req.getParameter("field"))) {
                if (addressService.delete(con,input)){
                    out.println(JsonConverter.toJson(input));
                }
            }
        } catch (SQLException e) {
            log(e.getMessage());
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    private String convertToObject(BufferedReader reader) {
        List<String> jsonLines = reader.lines().collect(Collectors.toList());
        String addressJson = String.join("", jsonLines);
        return addressJson;
    }
}
