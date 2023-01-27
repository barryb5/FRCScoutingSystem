package com.company.manager;

import com.company.services.StandardResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Manager {
    public static Connection db;

    public StandardResponse runTask() {
        // If this is called it means task is not yet implemented
        System.out.println("Unimplemented");

        return new StandardResponse();
    }

    public String stringifyResultSet(ResultSet resultSet) {
        try {
            ResultSetMetaData md = resultSet.getMetaData();
            int numCols = md.getColumnCount();
            List<String> colNames = IntStream.range(0, numCols)
                    .mapToObj(i -> {
                        try {
                            return md.getColumnName(i + 1);
                        } catch (SQLException e) {
                            e.printStackTrace();
                            return "?";
                        }
                    })
                    .collect(Collectors.toList());

            JSONArray result = new JSONArray();
            while (resultSet.next()) {
                JSONObject row = new JSONObject();
                colNames.forEach(cn -> {
                    try {
                        row.put(cn, resultSet.getObject(cn));
                    } catch (JSONException | SQLException e) {
                        e.printStackTrace();
                    }
                });
                result.put(row);
            }

            return result.toString();

        } catch (SQLException e) {
            return "Could not convert ResultSet to string";
        }
    }

    static {
        try {
            db = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (SQLException e) {
            System.out.println("Manager error");
            throw new RuntimeException(e);
        }
    }
}
