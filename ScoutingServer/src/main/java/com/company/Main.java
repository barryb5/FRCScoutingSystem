package com.company;

import com.company.services.StandardResponse;
import io.javalin.Javalin;
import io.javalin.Javalin.*;
import io.javalin.http.HttpStatus;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DatabaseManager databaseManager = new DatabaseManager();

        Javalin app = Javalin.create().start(4000);

        app.get("/", context -> {
            System.out.println("Saul Goodman");
            context.result("Saul Goodman");
        });


        app.get("/manager/{task}", ctx -> {
            StandardResponse response = databaseManager.runTask(ctx);
            System.out.println(ctx.path());
            if (response.status == HttpStatus.OK) {
                ctx.result(response.results);
            } else {
                ctx.json(response);
            }

            ctx.status(response.status);
        });

        app.post("/manager/{task}", ctx -> {
            StandardResponse response = databaseManager.runTask(ctx);
            ctx.json(response);
            ctx.status(response.status);
        });

    }
}
