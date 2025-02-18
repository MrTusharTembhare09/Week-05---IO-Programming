package com.ioprogramming.advancedproblems.jsontocsv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class JsonToCsvConverter {

    private static final String JSON_FILE = "src/main/resources/students_json.json";
    private static final String CSV_FILE = "src/main/resources/students_csv.csv";

    public static void main(String[] args) {
        // Convert JSON to CSV
        convertJsonToCsv();

        // Convert CSV to JSON
        convertCsvToJson();
    }

    // Method to convert JSON to CSV
    public static void convertJsonToCsv() {
        try {
            // Reading JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE)));
            JSONArray jsonArray = new JSONArray(jsonContent);

            // Writing to CSV file
            BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE));

            // Writing headers
            JSONObject firstObject = jsonArray.getJSONObject(0);
            Iterator<String> keys = firstObject.keys();
            StringBuilder headers = new StringBuilder();
            while (keys.hasNext()) {
                String key = keys.next();
                headers.append(key).append(",");
            }
            writer.write(headers.substring(0, headers.length() - 1));
            writer.newLine();

            // Writing data
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = jsonArray.getJSONObject(i);
                StringBuilder record = new StringBuilder();
                for (String key : student.keySet()) {
                    record.append(student.get(key)).append(",");
                }
                writer.write(record.substring(0, record.length() - 1));
                writer.newLine();
            }
            writer.close();
            System.out.println("JSON to CSV conversion successful!");

        } catch (Exception e) {
            System.err.println("Error during JSON to CSV conversion: " + e.getMessage());
        }
    }

    // Method to convert CSV to JSON
    public static void convertCsvToJson() {
        try {
            // Reading CSV file
            BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE));
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");

            // Reading data and converting to JSON
            JSONArray jsonArray = new JSONArray();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject student = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i]);
                }
                jsonArray.put(student);
            }
            reader.close();

            // Writing JSON to file
            Files.write(Paths.get("students_from_csv.json"), jsonArray.toString().getBytes());
            System.out.println("CSV to JSON conversion successful!");

        } catch (Exception e) {
            System.err.println("Error during CSV to JSON conversion: " + e.getMessage());
        }
    }
}

