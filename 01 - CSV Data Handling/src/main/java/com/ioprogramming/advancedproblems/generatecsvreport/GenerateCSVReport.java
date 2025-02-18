package com.ioprogramming.advancedproblems.generatecsvreport;

import java.io.*;
import java.sql.*;

public class GenerateCSVReport {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USER = "my_username";
    private static final String PASSWORD = "my_password";
    private static final String CSV_FILE = "my_report.csv";

    public static void main(String[] args) {
        generateCSVReport();
    }

    // Public method to fetch employee data from database and write it into CSV file
    public static void generateCSVReport() {
        String query = "SELECT EmployeeID, Name, Department, Salary FROM Employees";

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {

            // Writing CSV headers
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Writing data from result set into CSV file
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("EmployeeID");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                double salary = resultSet.getDouble("Salary");

                // Writing each record into CSV file
                writer.write(employeeId + "," + name + "," + department + "," + salary);
                writer.newLine();
            }

            System.out.println("CSV report generated successfully!");

        } catch (SQLException | IOException e) {
            System.err.println("Error while fetching data or writing CSV file: " + e.getMessage());
        }
    }
}

