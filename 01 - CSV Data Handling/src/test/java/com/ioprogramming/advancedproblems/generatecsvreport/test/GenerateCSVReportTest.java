package com.ioprogramming.advancedproblems.generatecsvreport.test;

import com.ioprogramming.advancedproblems.generatecsvreport.GenerateCSVReport;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class GenerateCSVReportTest {

    @Test
    void checkingCSVReportGeneration() {
        String testFile = "src/main/resources/test_employee_report.csv";

        // Calling the method to generate the CSV report
        GenerateCSVReport.generateCSVReport();

        // Checking if the file is generated
        File file = new File(testFile);
        assertTrue(file.exists(), "CSV report should be generated");

        // Checking if the CSV file contains headers and sample records
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String firstLine = reader.readLine();
            assertNotNull(firstLine, "CSV file should not be empty");
            assertTrue(firstLine.contains("Employee ID"), "CSV file should have 'Employee ID' as header");

            String secondLine = reader.readLine();
            assertNotNull(secondLine, "CSV file should contain records");
        } catch (IOException e) {
            fail("Failed to read the generated CSV file: " + e.getMessage());
        }
    }
}

