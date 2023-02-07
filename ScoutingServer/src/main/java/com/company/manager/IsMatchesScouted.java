package com.company.manager;

import com.company.generated.MatchScoutedStatus;
import com.company.services.StandardResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IsMatchesScouted extends Manager {
    public static final String name = "isMatchesScouted";

    private String tournamentKey;
    private String scouterName;
    private List<String> matchKeys;
    private ResultSet resultSet;

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        ObjectMapper mapper = new ObjectMapper();

        try {
            tournamentKey = ctx.queryParam("tournamentKey");
            scouterName = ctx.queryParam("scouterName");
            matchKeys = mapper.readValue(ctx.queryParam("matchKeys"), new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
            return response;
        }

        try {
            getData();
        } catch (Error e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
            return response;
        }

        try {
            List<MatchScoutedStatus> statuses = new ArrayList<>();
            boolean added = false;
            int resultSetLength = resultSet.getMetaData().getColumnCount();

            for (int i = 0; i < matchKeys.size(); i++) {
                resultSet.first();
                for (int j = 0; i < resultSetLength; j++) {
                    if (matchKeys.get(i).contains(resultSet.getString("matchKey") + "_")) {
                        statuses.add(new MatchScoutedStatus(resultSet.getString("matchKey") + "_", matchKeys.get(i)));
                        added = true;
                        break;
                    }
                    resultSet.next();
                }

                if (!added) {
                    statuses.add(new MatchScoutedStatus(matchKeys.get(i)));
                }

                added = false;
            }

            System.out.println(statuses);
            System.out.println(stringifyResultSet(resultSet));
            response.status = HttpStatus.OK;
            response.results = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(statuses);
        } catch (SQLException | JsonProcessingException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }

    private void getData() {
        String sql = "SELECT * FROM matches " +
                "LEFT JOIN data ON matches.key = data.matchKey " +
                "LEFT JOIN scouters ON data.scouterName = scouters.name " +
                "WHERE matches.tournamentKey = '" + tournamentKey + "' " +
                "AND data.scouterName = '" + scouterName + "' " +
                "AND (";

        for (int i = 0; i < matchKeys.size(); i++) {
            if (i != 0) {
                sql = sql + " OR ";
            }
            sql = sql + "INSTR(matches.key, '" + matchKeys.get(i) + "_')";
        }
        sql = sql + ")";

        try {
            Statement statement = db.createStatement();
            resultSet = statement.executeQuery(sql);
//            System.out.println(resultSet.getString("matchKey"));
        } catch (SQLException e) {
            System.out.println("Error creating/executing statement");
            throw new Error(e);
        }
    }
}
