package com.ioprogramming.handsonpracticeproblems.databasetojson;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseToJsonReportTest {

    @Test
    public void testJsonReportGeneration() {
        String filePath = "src/main/resources/test_report.json";
        DatabaseToJsonReport.generateJsonReport(filePath);

        // Checking if the file is created
        File file = new File(filePath);
        assertTrue(file.exists(), "JSON report file should exist");

        // Checking if file is not empty
        assertTrue(file.length() > 0, "JSON report should not be empty");
    }
}

