package com.ioprogramming.practiceproblems.extractjsonfields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class ExtractJsonFieldsTest {
    @Test
    void testExtractFields() throws Exception {
        // Creating ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Reading JSON file
        JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/data.json"));

        // Extracting first user details
        JsonNode firstUser = rootNode.get(0);
        String name = firstUser.get("name").asText();
        String email = firstUser.get("email").asText();

        // Verifying extracted data
        assertEquals("Alice Johnson", name);
        assertEquals("alice@example.com", email);
    }
}

