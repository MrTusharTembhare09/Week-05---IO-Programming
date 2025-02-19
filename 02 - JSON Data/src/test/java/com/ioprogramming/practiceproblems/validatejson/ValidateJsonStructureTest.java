package com.ioprogramming.practiceproblems.validatejson;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateJsonStructureTest {

    @Test
    void testValidJson() {
        String validJson = "{\"name\": \"John Doe\", \"age\": 25, \"email\": \"john@example.com\"}";
        assertTrue(ValidateJsonStructure.validateJson(validJson));
    }

    @Test
    void testInvalidJson() {
        String invalidJson = "{\"name\": \"Alice\", \"age\": 30}"; // Missing "email"
        assertFalse(ValidateJsonStructure.validateJson(invalidJson));
    }

    @Test
    void testMalformedJson() {
        String malformedJson = "{name: John, age: 25, email: john@example.com}"; // Incorrect format
        assertFalse(ValidateJsonStructure.validateJson(malformedJson));
    }
}

