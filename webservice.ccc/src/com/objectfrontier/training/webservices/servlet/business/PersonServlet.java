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
import com.objectfrontier.training.webservices.model.Person;
import com.objectfrontier.training.webservices.service.business.AppException;
import com.objectfrontier.training.webservices.service.business.ErrorCodes;
import com.objectfrontier.training.webservices.service.business.PersonService;
import com.objectfrontier.training.webservices.test.JsonConverter;

public class PersonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    PersonService personService;

    @Override
    public void init() {
        personService = new PersonService();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out;
        out = res.getWriter();
        Connection con = ConnectionManagement.myThreadLocal.get();
        try {
            if ("read".equalsIgnoreCase(req.getParameter("field"))){
                boolean includeAddress = true;
                long id = Long.parseLong(req.getParameter("id"));
                System.out.println(id);
                Person person = personService.read(con, id, includeAddress);
                res.setStatus(HttpServletResponse.SC_OK);
                out.write(JsonConverter.toJson(person));
            } else if ("readall".equalsIgnoreCase(req.getParameter("field"))) {
                List <Person> allPerson = personService.readAll(con);
                res.setStatus(HttpServletResponse.SC_OK);
                out.println(JsonConverter.toJson(allPerson));
            } else {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (SQLException e) {
            log(e.getMessage());
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out;
        out = resp.getWriter();
        Connection con = ConnectionManagement.myThreadLocal.get();
        try {
            BufferedReader reader = req.getReader();
            List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
            String personJson = String.join("", jsonLines); //or use readLine() Method with while block
            System.out.format("Input JSON >> %s", personJson);
            //Converting JSON to Object
            Person input = JsonConverter.toObject(personJson, Person.class);
            if ("create".equalsIgnoreCase(req.getParameter("field"))){
                //call address service
                Person person = personService.create(con,input);
                out.write(JsonConverter.toJson(person));
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (SQLException e) {
            log(e.getMessage());
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out;
        out = resp.getWriter();
        Connection con = ConnectionManagement.myThreadLocal.get();
        try {
            BufferedReader reader = req.getReader();
            List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
            String personJson = String.join("", jsonLines); //or use readLine() Method with while block
            System.out.format("Input JSON >> %s", personJson);
            //Converting JSON to Object
            Person input = JsonConverter.toObject(personJson, Person.class);
            if ("update".equalsIgnoreCase(req.getParameter("field"))){
                if (personService.update(con,input)) {
                    out.write(JsonConverter.toJson(input));
                }
            } else if ("delete".equalsIgnoreCase(req.getParameter("field"))){
                if (personService.delete(con,input)) {
                    out.write(JsonConverter.toJson(input));
                }
            }  else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (SQLException e) {
            log(e.getMessage());
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }
}
