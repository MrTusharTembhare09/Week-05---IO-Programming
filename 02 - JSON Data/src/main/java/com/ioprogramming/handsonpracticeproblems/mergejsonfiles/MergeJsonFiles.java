package com.ioprogramming.handsonpracticeproblems.mergejsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper for JSON handling
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading first JSON file
            JsonNode json1 = objectMapper.readTree(new File("src/main/resources/file1.json"));

            // Reading second JSON file
            JsonNode json2 = objectMapper.readTree(new File("src/main/resources/file2.json"));

            // Merging two JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Printing the merged JSON object
            System.out.println("Merged JSON: " + mergedJson.toPrettyString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
