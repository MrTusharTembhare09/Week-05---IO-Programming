package com.ioprogramming.handsonpracticeproblems.csvtojson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            // Converting CSV to JSON
            String jsonOutput = convertCsvToJson("src/main/resources/data.csv");

            // Printing the JSON output
            System.out.println("Converted JSON:\n" + jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Creating a method to convert CSV to JSON
    public static String convertCsvToJson(String csvFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        // Reading the first line to get headers
        String line = reader.readLine();
        if (line == null) return "[]";  // Returning empty JSON array if file is empty
        String[] headers = line.split(",");

        // Reading and processing each line
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            ObjectNode jsonObject = objectMapper.createObjectNode();
            for (int i = 0; i < headers.length; i++) {
                jsonObject.put(headers[i], values[i]);
            }
            jsonArray.add(jsonObject);
        }
        reader.close();

        // Returning JSON string
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
    }
}

