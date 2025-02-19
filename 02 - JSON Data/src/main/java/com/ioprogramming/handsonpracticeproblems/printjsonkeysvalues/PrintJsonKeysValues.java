package com.ioprogramming.handsonpracticeproblems.printjsonkeysvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintJsonKeysValues {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/data2.json"));

            // Printing all keys and values
            printJsonKeysAndValues(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method for printing all keys and values recursively
    private static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterating over all keys in the JSON object
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            // Iterating over JSON array
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), parentKey + "[" + i + "].");
            }
        } else {
            // Printing key-value pair
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " -> " + node.asText());
        }
    }
}

