package com.ioprogramming.advancedproblems.detectduplicates;

import java.io.*;
import java.util.*;

public class DetectDuplicateEntries {
    private static final String CSV_FILE = "src/main/resources/employees2.csv";

    public static void main(String[] args) {
        detectingDuplicateRecords(CSV_FILE);
    }

    // Public method to detect duplicate records in a CSV file
    public static void detectingDuplicateRecords(String filePath) {
        Map<String, String> recordMap = new HashMap<>();
        Set<String> duplicateRecords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skipping header row

            // Reading each record
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 4) continue; // Skipping invalid rows

                String id = columns[0].trim();
                String record = line.trim();

                // Checking for duplicates
                if (recordMap.containsKey(id)) {
                    duplicateRecords.add(record);
                } else {
                    recordMap.put(id, record);
                }
            }

            // Printing duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                duplicateRecords.forEach(System.out::println);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
