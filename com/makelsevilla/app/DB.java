package com.makelsevilla.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

/**
 * DBConnection
 * Singleton class
 * Eager Init
 */
public class DB {
    private static final DB instance = new DB();

    public final Connection conn;

    private DB() {
        Connection retrievedConn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // get the db creds from config files or something
            String dbURL = "jdbc:mysql://localhost:3306/java_kodz";
            String dbUser = "root";
            String dbPass = "";

            retrievedConn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e);
        }

        this.conn = retrievedConn;
    }

    public ResultSet query(String sql) throws SQLException, SQLTimeoutException {
        return conn.createStatement().executeQuery(sql);
    }

    public int execute(String query) throws SQLException, SQLTimeoutException{
        return conn.createStatement().executeUpdate(query);
    }

    // Static methods
    public static DB getInstance() {

        return instance;
    }
}
