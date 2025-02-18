package com.ioprogramming.practiceproblems.createjsonobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class CreateStudentJSON {

    public static void main(String[] args) {
        // Creating an ObjectMapper instance to handle JSON operations
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating a JSON object for the student
        ObjectNode studentNode = objectMapper.createObjectNode();

        // Adding properties to the student JSON object
        studentNode.put("name", "John Doe");
        studentNode.put("age", 20);

        // Creating an array node for subjects
        ArrayNode subjectsArray = objectMapper.createArrayNode();
        subjectsArray.add("Mathematics");
        subjectsArray.add("Science");
        subjectsArray.add("History");

        // Adding subjects array to student JSON object
        studentNode.set("subjects", subjectsArray);

        // Printing the created JSON to console
        try {
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentNode);
            System.out.println("Generated JSON Object:\n" + jsonString);

            // Saving the JSON object to a file
            objectMapper.writeValue(new File("src/main/resources/student.json"), studentNode);
            System.out.println("JSON file created successfully!");
        } catch (IOException e) {
            System.err.println("Error creating JSON file: " + e.getMessage());
        }
    }
}

