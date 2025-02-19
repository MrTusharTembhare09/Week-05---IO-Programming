package com.ioprogramming.handsonpracticeproblems.databasetojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        generateJsonReport("report.json");
    }

    // Creating method to generate JSON report
    public static void generateJsonReport(String outputFilePath) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "password"; // Change this to your MySQL password

        String query = "SELECT id, name, age, department FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter fileWriter = new FileWriter(outputFilePath)) {

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Iterating over result set
            while (rs.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("ID", rs.getInt("id"));
                jsonObject.put("Name", rs.getString("name"));
                jsonObject.put("Age", rs.getInt("age"));
                jsonObject.put("Department", rs.getString("department"));
                jsonArray.add(jsonObject);
            }

            // Writing JSON output to file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, jsonArray);
            System.out.println("JSON report generated successfully: " + outputFilePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

