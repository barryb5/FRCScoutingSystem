package com.company;

import com.company.manager.AddTournamentMatches;
import com.company.manager.GetMatches;
import com.company.manager.ResetAndPopulate;
import com.company.services.StandardResponse;
import io.javalin.http.Context;

public class DatabaseManager {
    DatabaseManager() {}

    public StandardResponse runTask(Context ctx) {
        switch (ctx.pathParam("task")) {
            case(ResetAndPopulate.name):
                return new ResetAndPopulate().runTask();
            case(AddTournamentMatches.name):
                return new AddTournamentMatches().runTask(ctx);
            case(GetMatches.name):
                return new GetMatches().runTask(ctx);
            default:
                // Task was missing
                return new StandardResponse();
        }
    }
}
