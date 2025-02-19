package com.ioprogramming.practiceproblems.filterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilterJsonByAgeTest {

    @Test
    void testFilterJsonByAge() {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating a JSON array as a string
            String jsonArray = "[{\"name\":\"Alice\", \"age\":22}, " +
                    "{\"name\":\"Bob\", \"age\":28}, " +
                    "{\"name\":\"Charlie\", \"age\":30}]";

            // Parsing JSON string into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonArray);

            // Creating a new JSON array to store filtered results
            ArrayNode filteredArray = objectMapper.createArrayNode();

            // Filtering records where age > 25
            for (JsonNode node : rootNode) {
                if (node.get("age").asInt() > 25) {
                    filteredArray.add(node);
                }
            }

            // Validating filtered JSON contains only Bob and Charlie
            assertEquals(2, filteredArray.size());
            assertEquals("Bob", filteredArray.get(0).get("name").asText());
            assertEquals("Charlie", filteredArray.get(1).get("name").asText());

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

