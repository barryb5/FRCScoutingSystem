package com.company.services;

import io.javalin.http.HttpStatus;

import java.sql.ResultSet;

public class StandardResponse {
    public HttpStatus status;
    public String textResponse;
    public String results;
    public StandardResponse() {
        status = HttpStatus.NOT_IMPLEMENTED;
        textResponse = "Task is not yet implemented";
    }
}
