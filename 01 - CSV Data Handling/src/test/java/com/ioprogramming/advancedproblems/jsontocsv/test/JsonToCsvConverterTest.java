package com.ioprogramming.advancedproblems.jsontocsv.test;

import com.ioprogramming.advancedproblems.jsontocsv.JsonToCsvConverter;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonToCsvConverterTest {

    @Test
    void checkingJsonToCsvConversion() {
        // Testing JSON to CSV conversion
        JsonToCsvConverter.convertJsonToCsv();

        // Checking if CSV file is generated
        File csvFile = new File("src/main/resources/students_csv.csv");
        assertTrue(csvFile.exists(), "CSV file should be generated");

        // Checking if the CSV file has headers and data
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String firstLine = reader.readLine();
            assertNotNull(firstLine, "CSV file should not be empty");
            assertTrue(firstLine.contains("ID"), "CSV file should have 'ID' as header");

            String secondLine = reader.readLine();
            assertNotNull(secondLine, "CSV file should contain records");
        } catch (IOException e) {
            fail("Failed to read the generated CSV file: " + e.getMessage());
        }
    }

    @Test
    void checkingCsvToJsonConversion() {
        // Testing CSV to JSON conversion
        JsonToCsvConverter.convertCsvToJson();

        // Checking if the JSON file is generated
        File jsonFile = new File("src/main/resources/students_json.json");
        assertTrue(jsonFile.exists(), "JSON file should be generated");

        // Checking if the JSON file contains data
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            String jsonContent = reader.readLine();
            assertNotNull(jsonContent, "JSON file should not be empty");
        } catch (IOException e) {
            fail("Failed to read the generated JSON file: " + e.getMessage());
        }
    }
}

