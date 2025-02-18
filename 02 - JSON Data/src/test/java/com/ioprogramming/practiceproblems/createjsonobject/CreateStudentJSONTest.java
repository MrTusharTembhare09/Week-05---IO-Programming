package com.ioprogramming.practiceproblems.createjsonobject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class CreateStudentJSONTest {

    @Test
    public void testJsonFileCreation() throws IOException {
        // Creating an instance of the main class
        CreateStudentJSON.main(new String[]{});

        // Reading the created JSON file
        File jsonFile = new File("src/main/resources/student.json");
        assertTrue(jsonFile.exists(), "JSON file should be created");

        // Parsing JSON file content
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonFile);

        // Validating JSON content
        assertEquals("John Doe", jsonNode.get("name").asText(), "Name should match");
        assertEquals(20, jsonNode.get("age").asInt(), "Age should match");
        assertTrue(jsonNode.get("subjects").isArray(), "Subjects should be an array");
        assertEquals(3, jsonNode.get("subjects").size(), "Subjects array should have 3 elements");
    }
}

