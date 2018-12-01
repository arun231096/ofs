package com.objectfrontier.training.webservices.servlet.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objectfrontier.training.webservices.connection.ConnectionManagement;
import com.objectfrontier.training.webservices.model.Person;
import com.objectfrontier.training.webservices.service.auth.Authentication;
import com.objectfrontier.training.webservices.test.JsonConverter;

public class AuthenticationServlet extends HttpServlet {

    Authentication authService;

  @Override
  public void init() {
      authService = new Authentication();
  }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        BufferedReader reader = req.getReader();
        List<String> jsonLines = reader.lines().collect(Collectors.toList());
        String personJson = String.join("", jsonLines);
        System.out.format("Input JSON >> %s", personJson);
        //Converting JSON to Object
        Person input = JsonConverter.toObject(personJson, Person.class);
        Connection con = ConnectionManagement.myThreadLocal.get();
        Person isadmin;
        try {
            isadmin = authService.login(con , input);
            System.out.println(isadmin.toString());
            HttpSession session = req.getSession(true);
            session.setAttribute("admin", isadmin.isIsadmin());
            session.setAttribute("person", isadmin);
            Cookie cookie = new Cookie("JSESSION_ID", session.getId());
            res.addCookie(cookie);
            out.write(JsonConverter.toJson(isadmin));
        } catch (SQLException e) {
            log(e.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
