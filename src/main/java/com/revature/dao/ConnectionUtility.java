package com.revature.dao;



import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    public static Connection createConnection() throws SQLException {
        Driver postgresDriver = new Driver();
        DriverManager.registerDriver(postgresDriver);

        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
        return con;
    }
}
