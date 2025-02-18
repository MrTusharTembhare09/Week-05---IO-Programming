package com.ioprogramming.advancedproblems.detectduplicates.test;

import com.ioprogramming.advancedproblems.detectduplicates.DetectDuplicateEntries;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class DetectDuplicateEntriesTest {

    @Test
    void checkingDuplicateDetection() {
        String testFile = "src/main/resources/test_employees.csv";

        // Creating a test CSV file with duplicate entries
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Test User1,IT,60000\n");
            writer.write("2,Test User2,HR,50000\n");
            writer.write("3,Test User3,Finance,70000\n");
            writer.write("4,Test User4,IT,80000\n");
            writer.write("3,Test User3,Finance,70000\n"); // Duplicate
            writer.write("2,Test User2,HR,50000\n"); // Duplicate
        } catch (IOException e) {
            fail("Failed to create test_employees.csv.");
        }

        // Redirect output to capture printed lines
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Running the duplicate detection method
        DetectDuplicateEntries.detectingDuplicateRecords(testFile);

        // Restoring the original output stream
        System.setOut(originalOut);

        // Checking if duplicate records were detected
        String output = outputStream.toString();
        assertTrue(output.contains("Duplicate Records Found"));
        assertTrue(output.contains("3,Test User3,Finance,70000"));
        assertTrue(output.contains("2,Test User2,HR,50000"));
    }
}

