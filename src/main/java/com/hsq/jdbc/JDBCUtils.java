package com.hsq.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        try {
            driver = resourceBundle.getString("driver");
            url = resourceBundle.getString("url");
            username = resourceBundle.getString("username");
            password = resourceBundle.getString("password");

            // load driver
            Class.forName(driver);
            // if success ,print it out
            System.out.println("success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            System.out.println("data connection successfully");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwable) {
            System.out.println("data connection failure");
            throwable.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
                //GC release
                resultSet = null;
            }
            if (preparedStatement != null) {
                preparedStatement.close();
                //GC release
                preparedStatement = null;
            }
            if (resultSet != null) {
                resultSet.close();
                //GC release
                resultSet = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
}