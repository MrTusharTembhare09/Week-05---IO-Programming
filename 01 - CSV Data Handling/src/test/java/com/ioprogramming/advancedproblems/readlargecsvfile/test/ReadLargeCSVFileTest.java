package com.ioprogramming.advancedproblems.readlargecsvfile.test;

import com.ioprogramming.advancedproblems.readlargecsvfile.ReadLargeCSVFile;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ReadLargeCSVFileTest {

    @Test
    void checkingChunkProcessing() {
        String testFile = "src/main/resources/test_large.csv";
        int testChunkSize = 3; // Testing with 3 lines at a time

        // Creating a small test CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Test User1,IT,60000\n");
            writer.write("2,Test User2,HR,50000\n");
            writer.write("3,Test User3,Finance,70000\n");
            writer.write("4,Test User4,IT,80000\n");
            writer.write("5,Test User5,Marketing,65000\n");
        } catch (IOException e) {
            fail("Failed to create test_large.csv.");
        }

        // Redirect output to capture printed lines
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Running the chunk processing method
        ReadLargeCSVFile.readingCSVInChunks(testFile, testChunkSize);

        // Restoring the original output stream
        System.setOut(originalOut);

        // Checking if the expected number of records were processed
        String output = outputStream.toString();
        assertTrue(output.contains("Processed 3 records so far"));
        assertTrue(output.contains("Total records processed: 5"));
    }
}

