package com.example.databas_lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    public static void main(String[] args) throws Exception {

        /*if (args.length != 2) {
            System.out.println("Usage: java JDBCTest <user> <password>");
            //System.out.println("vad som");
            System.exit(0);
        }*/

        String user = "root"; // user name
        String pwd = "android12"; // password
        System.out.println(user + ", *********");
        String database = "josefdb1"; // the name of the specific database
        String server
                = "jdbc:mysql://localhost:3306/" + database
                + "?UseClientEnc=UTF8";

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(server, user, pwd);
            System.out.println("Connected!");

            executeQuery(con, "SELECT * FROM bibla");
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                //System.out.println("fel med connection");
            }
        }
    }

    public static void executeQuery(Connection con, String query) throws SQLException {

        try (Statement stmt = con.createStatement()) {
            // Execute the SQL statement
            ResultSet rs = stmt.executeQuery(query);

            // Get the attribute names
            ResultSetMetaData metaData = rs.getMetaData();
            int ccount = metaData.getColumnCount();
            for (int c = 1; c <= ccount; c++) {
                System.out.print(metaData.getColumnName(c) + "\t");

            }
            System.out.println();

            // Get the attribute values
            while (rs.next()) {
                // NB! This is an example, -not- the preferred way to retrieve data.
                // You should use methods that return a specific data type, like
                // rs.getInt(), rs.getString() or such.
                // It's also advisable to store each tuple (row) in an object of
                // custom type (e.g. Employee).
                for (int c = 1; c <= ccount; c++) {
                    System.out.print(rs.getObject(c) + "\t");
                }
                System.out.println();
            }

        }
    }
}
