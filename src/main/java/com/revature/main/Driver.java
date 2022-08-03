package com.revature.main;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.utilty.ConnectionUtility;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
                app.start(8080);
        app.get("/", ctx -> ctx.result("Hello World"));

    }
}
