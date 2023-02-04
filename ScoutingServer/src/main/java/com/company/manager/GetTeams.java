package com.company.manager;

import com.company.services.StandardResponse;
import io.javalin.http.HttpStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTeams extends Manager {
    public static final String name = "getTeams";

    public StandardResponse runTask() {
        StandardResponse response = new StandardResponse();

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet teams = statement.executeQuery(
                    "SELECT * FROM teams"
            );

            response.status = HttpStatus.OK;
            response.results = stringifyResultSet(teams);
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }

}
