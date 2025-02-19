package com.ioprogramming.practiceproblems.filterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJsonByAge {
    public static void main(String[] args) {
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

            // Printing the filtered JSON array
            System.out.println("Filtered JSON (age > 25): " + filteredArray.toPrettyString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

