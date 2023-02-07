package com.company.manager;

import com.company.services.StandardResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.HttpStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetScouters extends Manager {
    public static final String name = "getScouters";

    public StandardResponse runTask() {
        StandardResponse response = new StandardResponse();

        try {
            Statement statement = db.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet scouters = statement.executeQuery(
                    "SELECT name FROM scouters"
            );

            List<String> returnScouters = new ArrayList<>();

            while (scouters.next()) {
                returnScouters.add(scouters.getString("name"));
            }

            ObjectMapper mapper = new ObjectMapper();

            response.status = HttpStatus.OK;
            response.results = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(returnScouters);
        } catch (SQLException | JsonProcessingException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
        }

        return response;
    }

}
