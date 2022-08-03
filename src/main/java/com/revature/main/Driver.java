package com.revature.main;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.utilty.ConnectionUtility;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        try {
            User bunu = new User(-1,"roserimu", "Rimsha", "roserimu@gmail.com", "password");
            User newlyInsertedUser= userDao.createUser(bunu);
            System.out.println(newlyInsertedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
