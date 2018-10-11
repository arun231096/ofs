package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        Connection con = DriverManager.getConnection("jdbc:mysql://pc1620:3306/arunkumar_angappan", "arunkumar_angappan", "demo");
        PreparedStatement st = con.prepareStatement("select * from employee");
        System.out.println("Connected");
        ResultSet rs;
        if ((rs = st.executeQuery()) != null) {
        if (rs.next()) {
            System.out.println(rs.getInt("id") +  " " +rs.getString("name"));
        }
        }
    }

}
