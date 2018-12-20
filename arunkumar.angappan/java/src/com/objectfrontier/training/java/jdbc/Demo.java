package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.jdbc.pojo.Person;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        Connection con = DriverManager.getConnection("jdbc:mysql://pc1620:3306/arunkumar_angappan", "arunkumar_angappan", "demo");
        String query = "SELECT * FROM person";
        PreparedStatement stmt =con.prepareStatement(query);
        ResultSet r= stmt.executeQuery();
        List <Person> result = new ArrayList<>();
        while (r.next()) {
            Person p = new Person();
            p.setId(r.getLong("id"));
            result.add(p);
        }
        System.out.println(result.size());
        }
    }

