package com.ioprogramming.handsonpracticeproblems.filterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FilterJsonDataTest {

    @Test
    void testFilterUsersOlderThan25() {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading the JSON file
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/users.json"));

            // Filtering users older than 25
            List<String> filteredUsers = new ArrayList<>();
            for (JsonNode user : rootNode) {
                if (user.get("age").asInt() > 25) {
                    filteredUsers.add(user.get("name").asText());
                }
            }

            // Checking if expected users are present
            assertTrue(filteredUsers.contains("John Doe"));
            assertTrue(filteredUsers.contains("Alice Brown"));
            assertFalse(filteredUsers.contains("Jane Smith"));
            assertFalse(filteredUsers.contains("Bob Johnson"));

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

