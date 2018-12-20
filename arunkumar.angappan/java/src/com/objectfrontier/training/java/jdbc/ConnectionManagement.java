package com.objectfrontier.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagement {

    public static Connection getConnection () throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://pc1620:3306/arunkumar_angappan", "arunkumar_angappan", "demo");
        return con;
    }

}
