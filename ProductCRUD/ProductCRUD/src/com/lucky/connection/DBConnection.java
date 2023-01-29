package com.saepul.connection;

import java.sql.DriverManager;
import java.sql.Connection;


public class DBConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost";

    private static Connection conn;

    private String database;
    private String pass;
    private String username;

    public DBConnection(String database, String username, String pass){
        this.database = database;
        this.username = username;
        this.pass = pass;
    }

    public void setConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(String.join("/", DB_URL, database), username, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConn(){
        return conn;
    }

}
