package com.ioprogramming.basicproblems.readcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    // Defining the path of the CSV file
    private static final String FILE_PATH = "src/main/resources/students.csv";

    public static void main(String[] args) {
        // Calling the method to read and print CSV data
        readingCSVFile(FILE_PATH);
    }

    // Reading the CSV file and printing its content
    private static void readingCSVFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Reading and ignoring the header line
            br.readLine();

            // Reading each record line by line
            while ((line = br.readLine()) != null) {
                // Splitting the CSV row into an array
                String[] values = line.split(",");

                // Printing the structured student details
                System.out.println("ID: " + values[0] +
                        ", Name: " + values[1] +
                        ", Age: " + values[2] +
                        ", Marks: " + values[3]);
            }
        } catch (IOException e) {
            // Handling file reading errors
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

