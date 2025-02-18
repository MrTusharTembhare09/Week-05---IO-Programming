package com.ioprogramming.intermediateproblems.modifycsv.test;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModifyCSVTest {

    // Testing if the output CSV file is created after modification
    @Test
    void checkingUpdatedCSVFileExists() {
        File updatedFile = new File("src/main/resources/updated_employees.csv");
        assertTrue(updatedFile.exists(), "Updated CSV file should be created.");
    }
}

