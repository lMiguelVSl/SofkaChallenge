package com.softka.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
    Connection connection;

    public SQLConnection(String hostname, int port, String username, String password){

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String dbURL = "jdbc:sqlserver://" + hostname + ":" + port + ";"
                        + "database=personas;"
                        + "user="+ username + ";"
                        + "password=" + password + ";" //genero la conexion con la base de datos local
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
            Connection conn = DriverManager.getConnection(dbURL);
            this.connection = conn;
            if (conn != null) {
                System.out.println("Connected"); //confirmo la conexion exitosa con la base de datos
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}