package com.ioprogramming.handsonpracticeproblems.mergejsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MergeJsonFilesTest {

    @Test
    void testMergeJsonFiles() {
        try {
            // Creating ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading both JSON files
            JsonNode json1 = objectMapper.readTree(new File("src/main/resources/file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("src/main/resources/file2.json"));

            // Merging JSON
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Checking if all fields are present
            assertTrue(mergedJson.has("name"));
            assertTrue(mergedJson.has("age"));
            assertTrue(mergedJson.has("email"));
            assertTrue(mergedJson.has("city"));

        } catch (IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

