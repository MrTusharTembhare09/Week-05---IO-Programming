package com.ioprogramming.practiceproblems.extractjsonfields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ExtractJsonFields {
    public static void main(String[] args) {
        // Creating ObjectMapper for JSON processing
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Reading JSON file into a JsonNode tree
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/data.json"));

            // Extracting and printing required fields (name & email)
            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                System.out.println("Name: " + name + ", Email: " + email);
            }

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }
}

