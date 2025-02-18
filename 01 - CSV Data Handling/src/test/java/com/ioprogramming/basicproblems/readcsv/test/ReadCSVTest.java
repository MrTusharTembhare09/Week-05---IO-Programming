package com.ioprogramming.basicproblems.readcsv.test;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadCSVTest {

    // Testing if the CSV file exists before reading
    @Test
    void checkingIfCSVFileExists() {
        File file = new File("src/main/resources/students.csv");
        assertTrue(file.exists(), "CSV file should exist before reading.");
    }
}
