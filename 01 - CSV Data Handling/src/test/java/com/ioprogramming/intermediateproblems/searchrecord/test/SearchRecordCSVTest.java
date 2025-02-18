package com.ioprogramming.intermediateproblems.searchrecord.test;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchRecordCSVTest {

    // Testing if the CSV file exists before searching
    @Test
    void checkingCSVFileExists() {
        File csvFile = new File("src/main/resources/employees.csv");
        assertTrue(csvFile.exists(), "CSV file should exist before searching for a record.");
    }
}
