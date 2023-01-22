package com.company.services;

import io.javalin.http.HttpStatus;

import java.sql.ResultSet;

public class StandardResponse {
    public HttpStatus status;
    public String textResponse;
    public ResultSet results;
    public StandardResponse() {

    }
}
