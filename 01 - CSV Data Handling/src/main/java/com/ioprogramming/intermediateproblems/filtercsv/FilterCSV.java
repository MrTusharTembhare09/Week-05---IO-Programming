package com.ioprogramming.intermediateproblems.filtercsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {

    // Defining the path of the CSV file
    private static final String FILE_PATH = "src/main/resources/students.csv";

    public static void main(String[] args) {
        // Calling method to read and filter records from CSV
        filteringRecordsFromCSV(FILE_PATH);
    }

    // Reading the CSV file and filtering records
    private static void filteringRecordsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading and ignoring the header line
            br.readLine();

            // Reading each record and printing only qualifying students
            while ((line = br.readLine()) != null) {
                String[] student = line.split(",");

                // Assuming the marks are in the 4th column (index 3)
                int marks = Integer.parseInt(student[3]);

                // Checking if the student's marks are greater than 80
                if (marks > 80) {
                    // Printing qualifying student's record
                    System.out.println("ID: " + student[0] + ", Name: " + student[1] + ", Age: " + student[2] + ", Marks: " + student[3]);
                }
            }
        } catch (IOException e) {
            // Handling file reading errors
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
