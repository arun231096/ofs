package com.objectfrontier.training.spring_view.utilities;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class ConnectionManagement {

    private static HikariDataSource dataSource;
    public static ThreadLocal<Connection> connectionThread = new ThreadLocal<>();

    static {

        String location = "/db.properties";
        HikariConfig config = new HikariConfig(location);
        config.setMaximumPoolSize(2);
        dataSource = new HikariDataSource(config);
    }

    public static void init() {
        connectionThread.set(getConnection());
    }

    public static Connection getCon() {
        return connectionThread.get();
    }
    public static Connection getConnection() {

        try {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    public static void release(Connection connection,boolean flag) {

        try {
            if (flag == true) {
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.close();
        } catch (SQLException e) {
            throw new AppException(ErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }
}