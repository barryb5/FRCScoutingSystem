package com.company.manager;

import com.company.generated.APITeam;
import com.company.generated.APITournament;
import com.company.generated.Scouter;
import com.company.services.StandardResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.Properties;

import static com.company.manager.Manager.db;

public class ResetAndPopulate extends Manager {
    public static final String name = "resetAndPopulate";

    public StandardResponse runTask() {
        StandardResponse response = new StandardResponse();

        String url = "https://www.thebluealliance.com/api/v3";

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

            statement.executeBatch();

            InputStream input = new FileInputStream("src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(input);

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet();
            getRequest.addHeader("X-TBA-Auth-Key", properties.getProperty("tbaKey"));

            ObjectMapper objectMapper = new ObjectMapper();

            for (int i = 0; i < 18; i++) {
                getRequest.setURI(URI.create(url + "/teams/" + i + "/simple"));

                HttpResponse apiResponse = httpClient.execute(getRequest);
                List<APITeam> teams = objectMapper.readValue(apiResponse.getEntity().getContent(), new TypeReference<List<APITeam>>(){});

                // Would use a lambda except it would require another try catch for the same exception, so I didn't
                for (APITeam team : teams) {
//                    System.out.println("INSERT INTO teams (key, teamNumber, teamName) VALUES ('" + team.getKey() + "', " + team.getTeamNumber() + ", '" + team.getName().replaceAll("'", "''") + "')");
                    statement.execute("INSERT INTO teams (key, teamNumber, teamName) VALUES ('" + team.getKey() + "', " + team.getTeamNumber() + ", '" + team.getName().replaceAll("'", "''") + "')");
                }

                System.out.println(((i+1)/18.0)*100 + "% Complete");
            }


            for (int i = 2022; i < 2024; i++) {
                getRequest.setURI(URI.create(url + "/events/" + i + "/simple"));

                HttpResponse apiResponse = httpClient.execute(getRequest);
                List<APITournament> tournaments = objectMapper.readValue(apiResponse.getEntity().getContent(), new TypeReference<List<APITournament>>(){});

                // Would use a lambda except it would require another try catch for the same exception, so I didn't
                for (APITournament tournament : tournaments) {
                    statement.execute("INSERT INTO tournaments (key, name, location, date) VALUES('" + tournament.getKey() + "', '" + tournament.getName().replaceAll("'", "''") + "', '" + tournament.getCity().replaceAll("'", "''") + "', '" + tournament.getStartDate().replaceAll("'", "''") + "')");
                }

                System.out.println(i + " Complete");
            }

            // Reads scouters file from resources and converts it to bytearray which converts it into a list of scouter objects
            List<Scouter> scouters = objectMapper.readValue(IOUtils.toByteArray(new FileInputStream("src/main/resources/scouters.json")), new TypeReference<List<Scouter>>(){});

            for (Scouter scouter : scouters) {
//                System.out.println(scouter);
                statement.execute("INSERT INTO scouters (name, phoneNumber, email) VALUES ('" + scouter.getName() + "', " + scouter.getNumber() + ", '" + scouter.getEmail() + "')");
            }

            System.out.println("Scouters Complete");

            statement.execute("PRAGMA foreign_keys = 1");

            response.status = HttpStatus.OK;
            response.textResponse = "Success";
        } catch (SQLException | IOException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }
}
