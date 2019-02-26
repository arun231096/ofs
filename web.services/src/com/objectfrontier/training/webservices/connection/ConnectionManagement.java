package com.objectfrontier.training.webservices.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.objectfrontier.training.webservices.service.AppException;
import com.objectfrontier.training.webservices.service.ErrorCodes;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class ConnectionManagement {

    private static HikariDataSource ds;
    {
        HikariConfig config = new HikariConfig("/com/objectfrontier/training/dbresource/dbConfig.properties");
        config.setMaximumPoolSize(2);
        ds = new HikariDataSource(config);
    }

    public Connection getConnection () throws SQLException, IOException {
        try {
            Connection con = ds.getConnection();
            con.setAutoCommit(false);
            return con;
        } catch (SQLException e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }
    public Connection getDbConnection() {
        FileReader hostFile;
        Connection con = null;
        try {
            hostFile = new FileReader("/com/objectfrontier/training/dbresource/db.properties");
            Properties hostProperties = new Properties();
            hostProperties.load(hostFile);
            con = DriverManager.getConnection(hostProperties.getProperty("host"), hostProperties.getProperty("username"), hostProperties.getProperty("password"));
        } catch (Exception e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
        return con;
    }
    public void release(Connection con, boolean status) {
        try {
            if (status == true) {
                con.commit();
                con.close();
            } else {
                con.rollback();
                con.close();
            }
        } catch (SQLException e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }
}
