package com.company.services;

import io.javalin.http.HttpStatus;

import java.sql.ResultSet;

public class StandardResponse {
    private HttpStatus status;
    public String textResponse;
    public ResultSet results;
    public StandardResponse() {

    }

    public HttpStatus getStatus() {
        return status;
    }

    public String jsonResponse() {
        return "asdf";
    }
}
