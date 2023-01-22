package com.company.manager;

import com.company.services.StandardResponse;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.sql.Statement;

import static com.company.manager.Manager.db;

public class ResetAndPopulate {
    public static final String name = "resetAndPopulate";
    public ResetAndPopulate() {

    }

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.execute("PRAGMA foreign_keys = 0");

            statement.execute("DROP TABLE IF EXISTS chats");
            statement.execute("DROP TABLE IF EXISTS messages");

            statement.execute("CREATE TABLE chats (id TEXT ONLY PRIMARY KEY)");

            statement.execute("CREATE TABLE messages (id INTEGER IDENTITY PRIMARY KEY, chatID TEXT ONLY NOT NULL, message TEXT ONLY, date TEXT ONLY, FOREIGN KEY(chatID) REFERENCES chats(id))");

            statement.execute("PRAGMA foreign_keys = 1");

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return response;
    }
}
