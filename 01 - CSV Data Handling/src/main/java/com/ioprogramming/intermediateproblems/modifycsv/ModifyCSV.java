package com.ioprogramming.intermediateproblems.modifycsv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSV {

    // Defining the paths for input and output CSV files
    private static final String INPUT_FILE = "src/main/resources/employees.csv";
    private static final String OUTPUT_FILE = "src/main/resources/updated_employees.csv";

    public static void main(String[] args) {
        // Calling method to update salaries and save to new file
        modifyingSalariesInCSV(INPUT_FILE, OUTPUT_FILE);
    }

    // Reading, modifying, and writing the updated CSV file
    private static void modifyingSalariesInCSV(String inputFile, String outputFile) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            // Reading the header
            String header = br.readLine();
            records.add(header.split(","));

            // Reading and modifying employee records
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                // Assuming Department is at index 2 and Salary at index 3
                if (employee[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(employee[3]);
                    salary *= 1.10; // Increasing salary by 10%
                    employee[3] = String.format("%.2f", salary); // Formatting salary
                }

                records.add(employee);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            return;
        }

        // Writing the updated records to a new file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] record : records) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Updated CSV file saved as: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing the updated CSV file: " + e.getMessage());
        }
    }
}

