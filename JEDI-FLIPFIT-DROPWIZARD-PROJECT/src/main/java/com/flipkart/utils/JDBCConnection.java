package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * Manages the JDBC connection to the database for the Flipkart system.
 * This class is responsible for establishing and maintaining a connection to a MySQL database,
 * ensuring that all database operations are performed over a valid and active connection.
 */
public class JDBCConnection {
    private static Connection connection = null;

    /**
     * Gets the active database connection. If the current connection is not valid, it attempts to establish a new one.
     * Uses default database credentials and settings to establish this connection.
     *
     * @return An active {@link Connection} object.
     */
    public static Connection getConnection() {
        try {
            if (isValid()) {
                return connection;
            } else {
                try {
                    Properties prop = new Properties();
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String url = "jdbc:mysql://127.0.0.1:3306/flipfit";
                    String user = "root";
                    String password = "Fk!@#%215046" ;
                    Class.forName(driver);
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Connected to database");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        }
        return connection;
    }

    /**
     * Checks if the current database connection is valid and open.
     *
     * @return true if the connection is valid and open, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
    public static boolean isValid() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}
