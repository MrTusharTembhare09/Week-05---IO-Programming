package com.ioprogramming.practiceproblems.mergejson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeJsonObjectsTest {
    @Test
    void testMergeJsonObjects() {
        try {
            // Creating an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating first JSON object
            ObjectNode json1 = objectMapper.createObjectNode();
            json1.put("name", "John");
            json1.put("age", 25);

            // Creating second JSON object
            ObjectNode json2 = objectMapper.createObjectNode();
            json2.put("email", "john@example.com");
            json2.put("phone", "9876543210");

            // Merging json2 into json1
            json1.setAll(json2);

            // Checking if all fields exist in the merged object
            assertEquals("John", json1.get("name").asText());
            assertEquals(25, json1.get("age").asInt());
            assertEquals("john@example.com", json1.get("email").asText());
            assertEquals("9876543210", json1.get("phone").asText());

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

