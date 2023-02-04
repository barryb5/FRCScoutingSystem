package com.company.manager;

import com.company.generated.APIMatch;
import com.company.generated.APITeam;
import com.company.services.StandardResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class AddTournamentMatches extends Manager {
    public static final String name = "addTournamentMatches";
    public AddTournamentMatches() {

    }

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        String url = "https://www.thebluealliance.com/api/v3";

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            InputStream input = new FileInputStream("src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(input);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet();
            getRequest.addHeader("X-TBA-Auth-Key", properties.getProperty("tbaKey"));

            ObjectMapper objectMapper = new ObjectMapper();

            String tournamentKey = ctx.queryParam("tournamentKey");

            getRequest.setURI(URI.create(url + "/event/" + tournamentKey + "/matches/simple"));
            HttpResponse apiResponse = httpClient.execute(getRequest);

            List<APIMatch> matches = objectMapper.readValue(apiResponse.getEntity().getContent(), new TypeReference<List<APIMatch>>(){});

            System.out.println("matches length " + matches.size());
//            for (APIMatch match : matches) {
//                System.out.println(match);
//            }

            for (APIMatch match : matches) {
                // Red goes before blue
                List<String> teams = new ArrayList<String>();
                teams.addAll(match.getAlliances().getRed().getTeamKeys());
                teams.addAll(match.getAlliances().getBlue().getTeamKeys());

                if (match.getCompLevel().equalsIgnoreCase("qm")) {
                    // Qual match
                    String matchValues = "";

                    for (int i = 0; i < teams.size(); i++) {
                        matchValues = String.format("('%s', '%s', %d, '%s', '%s')", (match.getKey() + "_" + i), match.getEventKey(), match.getMatchNumber(), teams.get(i), match.getCompLevel().toLowerCase());
                        statement.addBatch("INSERT INTO matches (key, tournamentKey, matchNumber, teamKey, matchType) VALUES " + matchValues);
                    }

                    try {
                        statement.executeBatch();
                    } catch (SQLException e) {
                        System.out.println(matchValues);
                        System.err.println( e.getClass().getName() + ": " + e.getMessage());
                    }

                } else {
                    // Non-qual match

                    String matchValues = "";

                    for (int i = 0; i < teams.size(); i++) {
//                        System.out.println(match.getKey().substring(match.getKey().length()-3, match.getKey().length()-2));
                        matchValues = String.format("('%s', '%s', %d, '%s', '%s')", (match.getKey().substring(0, match.getKey().length()-2) + "_" + i), match.getEventKey(), Integer.parseInt(match.getKey().substring(match.getKey().length()-3, match.getKey().length()-2)), teams.get(i), match.getCompLevel().toLowerCase());
//                        System.out.println(matchValues);
                        statement.addBatch("INSERT INTO matches (key, tournamentKey, matchNumber, teamKey, matchType) VALUES " + matchValues);
                    }
                    try {
                        statement.executeBatch();
                    } catch (SQLException e) {
                        System.out.println(matchValues);
                        System.err.println( e.getClass().getName() + ": " + e.getMessage());
                    }
                }
            }

            response.status = HttpStatus.OK;
            response.results = "Success";
        } catch (SQLException | IOException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }
}
