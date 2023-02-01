package com.company.manager;

import com.company.generated.ScoutReport;
import com.company.services.StandardResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.io.IOException;

public class AddScoutReport extends Manager {
    public static final String name = "addScoutReport";

    public StandardResponse runTask(Context ctx) {
        StandardResponse response = new StandardResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ScoutReport scoutReport = objectMapper.readValue(ctx.bodyAsBytes(), new TypeReference<ScoutReport>(){});
        } catch (IOException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
            response.status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.textResponse = e.getClass().getName() + ": " + e.getMessage();
            return response;
        }

        return response;
    }
}
