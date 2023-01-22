package com.company.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Manager {
    public static Connection db;

    static {
        try {
            db = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (SQLException e) {
            System.out.println("Manager error");
            throw new RuntimeException(e);
        }
    }
}
