package com.objectfrontier.training.webservices.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;
import com.objectfrontier.training.webservices.pojo.Person;
import com.objectfrontier.training.webservices.service.AppException;
import com.objectfrontier.training.webservices.service.PersonService;
import com.objectfrontier.training.webservices.test.JsonConverter;

public class PersonServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    PersonService personService;
//    Connection con;
    ConnectionManagement management;

    @Override
    public void init() {
        management = new ConnectionManagement();
        personService = new PersonService();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {

        PrintWriter out;
        try {
            out = res.getWriter();
            Connection con = management.getConnection();
            try {
                if ("read".equalsIgnoreCase(req.getParameter("field"))){
                    boolean includeAddress = true;
                    long id = Long.parseLong(req.getParameter("id"));
                    System.out.println(id);
                    Person person = personService.read(con, id, includeAddress);
                    management.release(con, true);
                    res.setStatus(HttpServletResponse.SC_OK);
                    out.write(JsonConverter.toJson(person));
                } else if ("readall".equalsIgnoreCase(req.getParameter("field"))) {
                    List <Person> allPerson = personService.readAll(con);
                    management.release(con, true);
                    res.setStatus(HttpServletResponse.SC_OK);
                    out.println(JsonConverter.toJson(allPerson));
                } else {
                    management.release(con, false);
                    res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                management.release(con, false);
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                if (e instanceof AppException) {
                    System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                    out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                } else {
                    throw e;
                }
            }
        } catch (Exception e1) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println(e1.getMessage());
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) {

        PrintWriter out;
        try {
            out = resp.getWriter();
            Connection con = management.getConnection();
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
                    management.release(con, true);
                    resp.setStatus(HttpServletResponse.SC_OK);
                    out.write(JsonConverter.toJson(person));
                } else {
                    management.release(con, false);
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                management.release(con, false);
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                if (e instanceof AppException) {
                    System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                    out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                } else {
                    throw e;
                }
            }
        } catch (Exception e1) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println(e1.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {

        PrintWriter out;
        try {
            out = resp.getWriter();
            Connection con = management.getConnection();
            try {
                BufferedReader reader = req.getReader();
                List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
                String personJson = String.join("", jsonLines); //or use readLine() Method with while block
                System.out.format("Input JSON >> %s", personJson);
                //Converting JSON to Object
                Person input = JsonConverter.toObject(personJson, Person.class);
                if ("update".equalsIgnoreCase(req.getParameter("field"))){
                    if (personService.update(con,input)) {
                        management.release(con, true);
                        resp.setStatus(HttpServletResponse.SC_OK);
                        out.write(JsonConverter.toJson(input));
                    }
                } else if ("delete".equalsIgnoreCase(req.getParameter("field"))){
                    if (personService.delete(con,input)) {
                        management.release(con, true);
                        resp.setStatus(HttpServletResponse.SC_OK);
                        out.write(JsonConverter.toJson(input));
                    }
                }  else {
                    management.release(con, false);
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } catch (Exception e) {
                management.release(con, false);
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                if (e instanceof AppException) {
                    System.out.println(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                    out.write(JsonConverter.toJson(((AppException) e).getErrorCodes()));
                } else {
                    throw e;
                }
            }
        } catch (Exception e1) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.out.println(e1.getMessage());
        }
    }
}