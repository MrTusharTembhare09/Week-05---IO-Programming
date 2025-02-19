package com.ioprogramming.handsonpracticeproblems.filterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class FilterJsonData {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/users.json"));

            // Iterating through the array and filtering users older than 25
            System.out.println("Users older than 25:");
            for (JsonNode user : rootNode) {
                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println(user.toPrettyString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

