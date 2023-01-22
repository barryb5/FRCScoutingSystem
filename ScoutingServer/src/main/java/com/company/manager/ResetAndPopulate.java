package com.company.manager;

import com.company.services.StandardResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.sql.PreparedStatement;
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

            statement.addBatch("PRAGMA foreign_keys = 0");

            statement.addBatch("DROP TABLE IF EXISTS teams");
            statement.addBatch("DROP TABLE IF EXISTS tournaments");
            statement.addBatch("DROP TABLE IF EXISTS matches");
            statement.addBatch("DROP TABLE IF EXISTS data");
            statement.addBatch("DROP TABLE IF EXISTS scouters");


            statement.addBatch("CREATE TABLE teams(key TEXT ONLY PRIMARY KEY, teamNumber INTEGER, teamName TEXT ONLY, UNIQUE (key, teamNumber, teamName))");
            statement.addBatch("CREATE TABLE tournaments (key TEXT ONLY PRIMARY KEY, name TEXT ONLY, location VARCHAR(50), date TEXT ONLY VARCHAR(20), UNIQUE (key, date))");
            statement.addBatch("CREATE TABLE matches (key PRIMARY KEY, tournamentKey TEXT ONLY NOT NULL, matchNumber INTEGER, teamKey TEXT ONLY, matchType TEXT ONLY NOT NULL, UNIQUE (tournamentKey, teamKey, matchType, matchNumber), FOREIGN KEY(tournamentKey) REFERENCES tournaments(key), FOREIGN KEY(teamKey) REFERENCES teams(key))");
            statement.addBatch("CREATE TABLE data (" +
                    "            uuid PRIMARY KEY," +
                    "            matchKey INTEGER NOT NULL, " +
                    "            scouterName TEXT ONLY VARCHAR(50) NOT NULL," +
                    "            startTime INTEGER NOT NULL," +
                    "            scoutReport," +
                    "            notes BLOB VARCHAR (250)," +
                    "            UNIQUE (matchKey, scouterName, scoutReport), " +
                    "            FOREIGN KEY(matchKey) REFERENCES matches(key)," +
                    "            FOREIGN KEY(scouterName) REFERENCES scouters(name))");
            statement.addBatch("CREATE TABLE scouters (" +
                    "            name TEXT ONLY PRIMARY KEY," +
                    "            phoneNumber INTEGER," +
                    "            email VARCHAR(100)," +
                    "            UNIQUE (name))");
            statement.addBatch("PRAGMA foreign_keys = 1");

            statement.executeBatch();

            response.status = HttpStatus.OK;
            response.textResponse = "Success";


        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }
}
