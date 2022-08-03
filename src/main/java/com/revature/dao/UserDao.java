package com.revature.dao;

import com.revature.model.User;
import com.revature.utilty.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // CREATE
    public User createUser(User user) throws SQLException {
        // Try-with resources
        // whatever object is being used within the () will automatically be closed
        // whenever the try-with-resources is done executing OR an exception occurs
         try(Connection con = ConnectionUtility.createConnection()) {
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO climawatch.users (username, name, email, password) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
             pstmt.setString(1, user.getUsername());
             pstmt.setString(2, user.getName());
             pstmt.setString(3, user.getEmail());
             pstmt.setString(4, user.getPassword());
             // executeUpdate is used to execute DML statements
             // Particularly INSERT, UPDATE and DELETE
             int numberOfRecordsInserted = pstmt.executeUpdate();
             // Retrieve autoGenerated snum serial
             ResultSet rs =pstmt.getGeneratedKeys();
             rs.next(); // moves the cursor to the next row in the ResultSet
            int autoGeneratedSnum =  rs.getInt(1);
            return new User(autoGeneratedSnum, user.getUsername(), user.getName(), user.getEmail(), user.getPassword());
        }
    }

    // READ
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try(Connection con = ConnectionUtility.createConnection()){
            Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM climawatch.users");
           //rs.next() does 2 things
           // 1) rs.next() also moves the cursor to the next record
           // 2) rs.next() returns a boolean that is true if there is a next record, false if there's no more records
           while (rs.next()){
               int snum = rs.getInt("snum");
               String username = rs.getString("username");
               String name = rs.getString("name");
               String email = rs.getString("email");
               String password = rs.getString("password");

               User user = new User(snum, username, name, email, password);
               users.add(user); // add user object to users list ;
           }
           return users;
        }
    }

    // UPDATE user using the username provided in the user object parameter
    public User updateUser(User user) throws SQLException {
        try(Connection con = ConnectionUtility.createConnection()){
            PreparedStatement pstmt = con.prepareStatement("UPDATE climawatch.users SET password=? where username=?");
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getUsername());

            int numberOfUpdatedRecords =  pstmt.executeUpdate();

            return new User(user.getSnum(), user.getUsername(), user.getName(), user.getEmail(), user.getPassword());

        }
    }

    // DELETE user using username provided in the user object parameter
    public boolean deleteUserByUserName(String username) throws SQLException {
        try(Connection con = ConnectionUtility.createConnection()){
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM climawatch.users WHERE username=?");
            pstmt.setString(1, username);
           int numberOfRecordsDeleted =  pstmt.executeUpdate();
           return numberOfRecordsDeleted == 1;
        }
    }

//    // GET user by username
//    public User getUserByUsername(String username){
//
//    }
}
