package com.ioprogramming.practiceproblems.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonConverter {

    // Defining a simple Java class
    static class Student {
        public String name;
        public int age;
        public String email;

        // Creating a constructor
        public Student(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
    }

    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating a list of Student objects
            List<Student> students = new ArrayList<>();
            students.add(new Student("Alice", 22, "alice@example.com"));
            students.add(new Student("Bob", 24, "bob@example.com"));
            students.add(new Student("Charlie", 21, "charlie@example.com"));

            // Converting the list to a JSON array
            String jsonArray = objectMapper.writeValueAsString(students);

            // Printing the JSON array
            System.out.println("JSON Array: " + jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

