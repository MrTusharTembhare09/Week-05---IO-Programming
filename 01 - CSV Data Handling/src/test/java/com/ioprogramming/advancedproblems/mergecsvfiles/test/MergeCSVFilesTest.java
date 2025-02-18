package com.ioprogramming.advancedproblems.mergecsvfiles.test;

import com.ioprogramming.advancedproblems.mergecsvfiles.MergeCSVFiles;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MergeCSVFilesTest {

    @Test
    void checkingMergedFileContents() {
        String testFile1 = "test_students1.csv";
        String testFile2 = "test_students2.csv";
        String testOutputFile = "test_merged_students.csv";

        // Creating test CSV files
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile1))) {
            writer.write("ID,Name,Age\n");
            writer.write("1,Test User1,20\n");
            writer.write("2,Test User2,21\n");
        } catch (IOException e) {
            fail("Failed to create test_students1.csv.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile2))) {
            writer.write("ID,Marks,Grade\n");
            writer.write("1,85,A\n");
            writer.write("2,90,A+\n");
        } catch (IOException e) {
            fail("Failed to create test_students2.csv.");
        }

        // Running the merge function
        MergeCSVFiles.mergingCSVFiles(testFile1, testFile2, testOutputFile);

        // Reading merged file and verifying contents
        try {
            List<String> lines = Files.readAllLines(Paths.get(testOutputFile));
            assertEquals(3, lines.size()); // 1 header + 2 records
            assertEquals("ID,Name,Age,Marks,Grade", lines.get(0)); // Header check
            assertTrue(lines.contains("1,Test User1,20,85,A"));
            assertTrue(lines.contains("2,Test User2,21,90,A+"));
        } catch (IOException e) {
            fail("Failed to read merged test CSV file.");
        }
    }
}
