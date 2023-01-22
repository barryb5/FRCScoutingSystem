package com.company;

import com.company.manager.ResetAndPopulate;
import com.company.services.StandardResponse;
import io.javalin.http.Context;

public class DatabaseManager {
    DatabaseManager() {}

    // Scenarios for get request
    public StandardResponse runGetTask(Context ctx) {
        switch (ctx.pathParam("task")) {
            case(ResetAndPopulate.name):
                return new ResetAndPopulate().runTask(ctx);
            default:
                // Task was missing
                return new StandardResponse();
        }
    }

    // Scenarios for post request
    public StandardResponse runPostTask(Context ctx) {
        switch (ctx.pathParam("task")) {
            case(ResetAndPopulate.name):
                return new ResetAndPopulate().runTask(ctx);
            default:
                // Task was missing
                return new StandardResponse();
        }
    }
}
