package com.ioprogramming.practiceproblems.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonStructure {

    // Validating JSON structure
    public static boolean validateJson(String jsonString) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parsing the JSON string
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Checking if the required fields exist
            return jsonNode.has("name") && jsonNode.has("age") && jsonNode.has("email");
        } catch (Exception e) {
            // Printing error message if JSON is invalid
            System.out.println("Invalid JSON: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Creating sample JSON strings for testing
        String validJson = "{\"name\": \"John Doe\", \"age\": 25, \"email\": \"john@example.com\"}";
        String invalidJson = "{\"name\": \"Alice\", \"age\": 30}"; // Missing "email"

        // Validating JSON
        System.out.println("Is valid JSON? " + validateJson(validJson)); // Expected: true
        System.out.println("Is valid JSON? " + validateJson(invalidJson)); // Expected: false
    }
}

