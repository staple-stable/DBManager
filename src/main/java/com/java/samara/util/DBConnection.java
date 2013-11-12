package com.java.samara.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Aleksandr_Mishin
 * Date: 11/11/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBConnection {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String DB_PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String DB_USER = "sys as sysdba";
    private static String DB_PASSWORD = "hk4tio";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
