package com.ioprogramming.intermediateproblems.searchrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecordCSV {

    // Defining the path of the CSV file
    private static final String FILE_PATH = "src/main/resources/employees.csv";

    public static void main(String[] args) {
        // Taking employee name as input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name to search: ");
        String searchName = scanner.nextLine();
        scanner.close();

        // Calling method to search and display employee details
        searchingEmployeeRecord(FILE_PATH, searchName);
    }

    // Reading CSV and searching for an employee record
    private static void searchingEmployeeRecord(String filePath, String employeeName) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading and ignoring the header line
            br.readLine();

            // Searching for the employee record
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");

                // Assuming Name is in the second column (index 1)
                if (employee[1].equals(employeeName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + employee[2]);
                    System.out.println("Salary: " + employee[3]);
                    found = true;
                    break;
                }
            }

            // Handling case if employee is not found
            if (!found) {
                System.out.println("Employee not found!");
            }

        } catch (IOException e) {
            // Handling file reading errors
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

