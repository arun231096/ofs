package com.objectfrontier.training.java.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Resource {

    private static Connection connection;

    public void createConnection () throws SQLException, IOException {
        setConnection(new ConnectionManagement().getConnection());
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        Resource.connection = connection;
    }

    public void relaseConnection() throws SQLException {
        connection.close();
    }
}
