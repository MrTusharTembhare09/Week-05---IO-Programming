package com.ioprogramming.handsonpracticeproblems.csvtojson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class CsvToJsonConverterTest {

    @Test
    public void testCsvToJsonConversion() {
        try {
            // Testing conversion method with a sample CSV file
            String jsonResult = CsvToJsonConverter.convertCsvToJson("src/main/resources/data.csv");

            // Checking if JSON output contains expected values
            assertTrue(jsonResult.contains("\"ID\": \"1\""));
            assertTrue(jsonResult.contains("\"Name\": \"John\""));
            assertTrue(jsonResult.contains("\"Age\": \"28\""));
            assertTrue(jsonResult.contains("\"Department\": \"IT\""));
        } catch (IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

