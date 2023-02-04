package com.company.manager;

import com.company.services.StandardResponse;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetTeamsInTournament extends Manager {
    public static final String name = "getTeamsInTournament";
    private String tournamentKey;

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        tournamentKey = ctx.queryParam("tournamentKey");

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.



            ResultSet teams = statement.executeQuery(
                    "SELECT DISTINCT teams.key, teamNumber, teamName FROM matches " +
                        "INNER JOIN teams ON matches.teamKey = teams.key " +
                        "WHERE matches.tournamentKey = '" + tournamentKey +"' " +
                        "ORDER BY teamNumber"
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
