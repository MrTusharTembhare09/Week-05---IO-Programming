package com.ioprogramming.basicproblems.countrows.test;

import com.ioprogramming.basicproblems.countrows.CountRowsCSV;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountRowsCSVTest {

    // Testing if the program correctly counts the rows in the CSV file
    @Test
    void checkingRowCount() {
        // Path to the CSV file
        String filePath = "src/main/resources/employees.csv";

        // Expected row count (excluding header)
        int expectedRowCount = 5;

        // Reading the CSV file and counting rows
        int actualRowCount = 0;
        try {
            actualRowCount = CountRowsCSV.countingRowsInCSV(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Asserting that the counted rows match the expected value
        assertEquals(expectedRowCount, actualRowCount, "Row count should match the expected value.");
    }
}

