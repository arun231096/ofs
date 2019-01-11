package com.objectfrontier.training.springRest.connection;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.objectfrontier.training.springRest.utilities.AppException;
import com.objectfrontier.training.springRest.utilities.ErrorCodes;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class ConnectionManagement {

    private static HikariDataSource ds;
    public static ThreadLocal<Connection> myThreadLocal = new ThreadLocal<>();
    public static int init() {
        myThreadLocal.set(getConnection());
        return 1;
    }

    {
        HikariConfig config = new HikariConfig("application.properties");
        config.setMaximumPoolSize(2);
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection () {
        try {
            Connection con = ds.getConnection();
            con.setAutoCommit(false);
            return con;
        } catch (Exception e) {
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
            con = DriverManager.getConnection(hostProperties.getProperty("host"),
                                              hostProperties.getProperty("username"),
                                              hostProperties.getProperty("password"));
        } catch (Exception e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
        return con;
    }
    public static void release(Connection con, boolean status) {
        try {
            if (status == true) {
                con.commit();
            } else {
                con.rollback();
            }
            con.close();
        } catch (SQLException e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }
}
