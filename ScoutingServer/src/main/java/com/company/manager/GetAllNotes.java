package com.company.manager;

import com.company.services.StandardResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllNotes extends Manager {
    public static final String name = "getAllNotes";
    private String tournamentKey;
    private double startTime;

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        tournamentKey = ctx.queryParam("tournamentKey");
        startTime = 0;
        try {
            startTime = Double.parseDouble(ctx.queryParam("startTime"));
        } catch (NumberFormatException ex) {
            System.out.println("Given String is not parsable to double");
        }

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            String sql = "SELECT * FROM matches " +
                        "WHERE tournamentKey = '" + tournamentKey + "' ";

            if (0 != startTime) {
                sql += " AND startTime > " + startTime;
            }

            ResultSet notes = statement.executeQuery(sql);

            if (notes.next() == false) {
                // matches is empty
                System.out.println("No content in notes");
                response.status = HttpStatus.NO_CONTENT;
                response.textResponse = "No notes found";
            } else {
                System.out.println("Success");
                response.status = HttpStatus.OK;
                response.textResponse = "Success";
                response.results = stringifyResultSet(notes);
            }

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }
}
