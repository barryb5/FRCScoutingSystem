package com.company.manager;

import com.company.generated.GameDependent;
import com.company.generated.ScoutReport;
import com.company.services.StandardResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddScoutReport extends Manager {
    public static final String name = "addScoutReport";
    private ScoutReport scoutReport;
    private GameDependent gameDependent;

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Add values to scoutReport and gameDependent
            scoutReport = objectMapper.readValue(ctx.bodyAsBytes(), new TypeReference<ScoutReport>(){});
            gameDependent = new GameDependent();
            gameDependent.setEvents(scoutReport.getEvents());
            gameDependent.setAutoChallengeResult(gameDependent.getAutoChallengeResult());
            gameDependent.setChallengeResult(gameDependent.getChallengeResult());
            gameDependent.setRobotRole(gameDependent.getRobotRole());
        } catch (IOException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
            return response;
        }

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet matchKey = statement.executeQuery(
                "SELECT * FROM matches " +
                    "WHERE teamKey = 'frc" + scoutReport.getTeamNumber() + "'" +
                    "AND tournamentKey = '" + scoutReport.getTournamentKey() + "'" +
                    "AND SUBSTRING(key, 1, LENGTH(key)-1) = '" + scoutReport.getTournamentKey() + "_" + scoutReport.getMatchKey() + "_'"
            );

            if (matchKey.next()) {
                scoutReport.setMatchKey(matchKey.getString(1));
            } else {
                System.out.println("Match doesn't exist");
                response.status = HttpStatus.INTERNAL_SERVER_ERROR;
                response.textResponse = "Match doesn't exist";
                return response;
            }
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage() + "\n Match doesn't exist";
            return response;
        }

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.execute("INSERT INTO data (uuid, matchKey, scouterName, startTime, scoutReport, notes) VALUES " +
                    "('" + scoutReport.getUuid() + "', " +
                    "'" + scoutReport.getMatchKey() + "', " +
                    "'" + scoutReport.getScouterName() + "', " +
                    scoutReport.getStartTime() + ", " +
                    "'" + gameDependent.toString() + "', " +
                    "'" + scoutReport.getNotes() + "'" +
                    ")");

            response.status = HttpStatus.OK;
            response.textResponse = "Success";

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
            return response;
        }

        return response;
    }
}
