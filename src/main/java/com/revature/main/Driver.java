package com.revature.main;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.utilty.ConnectionUtility;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        try {
            User userToUpdate = new User(1, "bipul513", "Bipul", "bipulc@gmail.com", "password123");
            System.out.println(userDao.updateUser(userToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
