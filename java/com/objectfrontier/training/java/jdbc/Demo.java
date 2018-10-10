package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        Connection con = DriverManager.getConnection("jdbc:mysql://pc1620:3306/arunkumar_angappan", "arunkumar_angappan", "demo");
        if (con != null) {
            System.out.println("Connected");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  " " +rs.getString("name"));
            }
        } else {
            System.out.println("Not Connected");
        }
    }

}
