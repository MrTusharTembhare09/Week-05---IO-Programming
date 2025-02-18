package com.ioprogramming.advancedproblems.mergecsvfiles;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    // Defining file paths
    private static final String STUDENTS1_FILE = "src/main/resources/students01.csv";
    private static final String STUDENTS2_FILE = "src/main/resources/students02.csv";
    private static final String MERGED_FILE = "src/main/resources/merged_students.csv";

    public static void main(String[] args) {
        // Calling method to merge CSV files
        mergingCSVFiles(STUDENTS1_FILE, STUDENTS2_FILE, MERGED_FILE);
        System.out.println("Merged file created: " + MERGED_FILE);
    }

    // Public method to merge two CSV files based on ID
    public static void mergingCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> studentData = new LinkedHashMap<>();

        // Reading first CSV file (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // Skipping header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                studentData.put(data[0], new String[]{data[1], data[2]}); // Storing ID, Name, Age
            }
        } catch (IOException e) {
            System.err.println("Error reading " + file1 + ": " + e.getMessage());
        }

        // Reading second CSV file (ID, Marks, Grade) and merging data
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            br.readLine(); // Skipping header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (studentData.containsKey(data[0])) {
                    String[] existingData = studentData.get(data[0]);
                    studentData.put(data[0], new String[]{existingData[0], existingData[1], data[1], data[2]});
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading " + file2 + ": " + e.getMessage());
        }

        // Writing merged data to new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("ID,Name,Age,Marks,Grade\n"); // Writing header
            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                String[] values = entry.getValue();
                if (values.length == 4) {
                    writer.write(entry.getKey() + "," + values[0] + "," + values[1] + "," + values[2] + "," + values[3] + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing merged file: " + e.getMessage());
        }
    }
}

