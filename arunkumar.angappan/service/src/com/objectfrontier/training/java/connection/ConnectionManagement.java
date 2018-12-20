package com.objectfrontier.training.java.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class ConnectionManagement {

    public HikariDataSource hikariConnection() {

        HikariConfig config = new HikariConfig("res/com/objectfrontier/training/dbresource/dbConfig.properties");
        config.setMaximumPoolSize(2);
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    public Connection getConnection () throws SQLException, IOException {
        FileReader hostFile = new FileReader("res/com/objectfrontier/training/dbresource/db.properties");
        Properties hostProperties = new Properties();
        hostProperties.load(hostFile);
        Connection con = DriverManager.getConnection(hostProperties.getProperty("host"), hostProperties.getProperty("username"), hostProperties.getProperty("password"));
        return con;
    }

}
