package com.company;

import com.company.manager.*;
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
            case(GetAllNotes.name):
                return new GetAllNotes().runTask(ctx);
            case(AddScoutReport.name):
                return new AddScoutReport().runTask(ctx);
            case(GetScouters.name):
                return new GetScouters().runTask();
            case(GetTeams.name):
                return new GetTeams().runTask();
            case(GetTeamsInTournament.name):
                return new GetTeamsInTournament().runTask(ctx);
            case(IsMatchesScouted.name):
                return new IsMatchesScouted().runTask(ctx);
            default:
                // Task was missing
                return new StandardResponse();
        }
    }
}
