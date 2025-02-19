package com.ioprogramming.handsonpracticeproblems.printjsonkeysvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class PrintJsonKeysValuesTest {

    @Test
    void testPrintJsonKeysAndValues() {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/data2.json"));

            // Checking if the root node is not null
            assertNotNull(rootNode);

            // Checking if required fields exist
            assertTrue(rootNode.has("name"));
            assertTrue(rootNode.has("age"));
            assertTrue(rootNode.has("email"));
            assertTrue(rootNode.has("address"));
            assertTrue(rootNode.get("address").has("city"));
            assertTrue(rootNode.get("address").has("zip"));

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

