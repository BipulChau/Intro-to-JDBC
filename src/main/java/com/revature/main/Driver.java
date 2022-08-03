package com.revature.main;

import com.revature.dao.ConnectionUtility;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        try {
            Connection con = ConnectionUtility.createConnection();
            System.out.println(con);
        } catch (SQLException e) {
            System.out.println("Not done");
            throw new RuntimeException(e);
        }
    }
}
