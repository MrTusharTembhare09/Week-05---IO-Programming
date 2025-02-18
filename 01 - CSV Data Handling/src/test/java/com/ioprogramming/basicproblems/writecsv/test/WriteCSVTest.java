package com.ioprogramming.basicproblems.writecsv.test;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WriteCSVTest {

    // Testing if the CSV file is created successfully
    @Test
    void checkingIfCSVFileIsCreated() {
        File file = new File("src/main/resources/employees.csv");
        assertTrue(file.exists(), "CSV file should be created successfully.");
    }
}

