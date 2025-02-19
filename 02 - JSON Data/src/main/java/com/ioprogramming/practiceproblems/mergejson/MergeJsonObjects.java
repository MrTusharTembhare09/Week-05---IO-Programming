package com.ioprogramming.practiceproblems.mergejson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper to handle JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating first JSON object
            ObjectNode json1 = objectMapper.createObjectNode();
            json1.put("name", "John");
            json1.put("age", 25);

            // Creating second JSON object
            ObjectNode json2 = objectMapper.createObjectNode();
            json2.put("email", "john@example.com");
            json2.put("phone", "9876543210");

            // Merging second JSON object into the first
            json1.setAll(json2);

            // Printing the merged JSON object
            System.out.println("Merged JSON: " + json1.toPrettyString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

