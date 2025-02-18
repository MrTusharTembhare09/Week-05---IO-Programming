package com.ioprogramming.intermediateproblems.sortcsv;

import java.io.*;
import java.util.*;

public class SortCSV {

    // Defining the path for the input CSV file
    private static final String INPUT_FILE = "src/main/resources/employees.csv";

    public static void main(String[] args) {
        // Calling method to sort records by Salary and print top 5
        sortingAndDisplayingTopSalaries(INPUT_FILE);
    }

    // Public method to sort CSV by salary in descending order and return sorted records
    public static List<String[]> sortingAndDisplayingTopSalaries(String inputFile) {
        List<String[]> records = new ArrayList<>();
        String header = "";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            // Reading the header separately
            header = br.readLine();

            // Reading the records
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }

            // Sorting records based on Salary (index 3), in descending order
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            // Printing top 5 highest-paid employees
            System.out.println(header);
            int count = 0;
            for (String[] record : records) {
                if (count < 5) {
                    System.out.println(String.join(",", record));
                    count++;
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        return records; // Returning sorted records for testing
    }
}


