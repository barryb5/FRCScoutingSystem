package com.company.manager;

import com.company.services.StandardResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetMatches extends Manager {
    public static final String name = "getMatches";
    private String tournamentKey;

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();
        tournamentKey = ctx.queryParam("tournamentKey");

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            try {
                ResultSet matches = statement.executeQuery("SELECT * FROM matches " +
                        "WHERE tournamentKey = '" + tournamentKey + "' " +
                        "ORDER BY matchNumber");

                System.out.println(matches);
                if (matches.next() == false) {
                    // matches is empty
                    System.out.println("No content in matches");
                    response.status = HttpStatus.NO_CONTENT;
                    response.textResponse = "No matches found";
                } else {
                    System.out.println("Success");
                    response.status = HttpStatus.OK;
                    response.textResponse = "Success";
                    response.results = stringifyResultSet(matches);
                }


            } catch (SQLException e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage());
                response.status = HttpStatus.INTERNAL_SERVER_ERROR;
                response.textResponse = "Error reading matches table";
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }
}
