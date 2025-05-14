package model;

import java.sql.*;

public class ConexionMySQL {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jardineria";
    private static final String USER = "jardineria";
    private static final String PASS = "jardineria";

    public static Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
