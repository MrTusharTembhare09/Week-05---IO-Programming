package com.ioprogramming.basicproblems.writecsv;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    // Defining the path of the CSV file
    private static final String FILE_PATH = "src/main/resources/employees.csv";

    public static void main(String[] args) {
        // Calling method to write data to CSV
        writingDataToCSV(FILE_PATH);
    }

    // Writing employee details to CSV file
    private static void writingDataToCSV(String filePath) {
        // Sample employee data
        String[] employees = {
                "101, Alice Johnson, HR, 55000",
                "102, Bob Smith, Finance, 65000",
                "103, Charlie Davis, Engineering, 75000",
                "104, David Wilson, Marketing, 60000",
                "105, Eve Brown, Sales, 50000"
        };

        try (FileWriter writer = new FileWriter(filePath)) {
            // Writing header to CSV file
            writer.append("ID, Name, Department, Salary\n");

            // Writing employee records
            for (String employee : employees) {
                writer.append(employee).append("\n");
            }

            // Flushing the writer
            writer.flush();

            System.out.println("CSV file created and data written successfully.");
        } catch (IOException e) {
            // Handling file writing errors
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}

