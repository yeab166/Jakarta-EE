package com.attendance.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7827592";
    private static final String USER = "sql7827592";
    private static final String PASSWORD = "QMwKh3ZqLb";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}