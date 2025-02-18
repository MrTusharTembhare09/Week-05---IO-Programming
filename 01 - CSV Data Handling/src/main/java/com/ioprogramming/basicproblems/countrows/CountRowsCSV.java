package com.ioprogramming.basicproblems.countrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsCSV {

    // Defining the path of the CSV file
    private static final String FILE_PATH = "src/main/resources/employees.csv";

    public static void main(String[] args) {
        // Calling method to read and count rows in CSV
        try {
            int rowCount = countingRowsInCSV(FILE_PATH);
            System.out.println("Total records (excluding header): " + rowCount);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    // Reading the CSV file and counting rows
    public static int countingRowsInCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowCount = 0;

            // Reading and ignoring the header line
            br.readLine();

            // Reading each record and counting rows
            while ((line = br.readLine()) != null) {
                rowCount++;
            }
            return rowCount;
        }
    }
}


