package com.ioprogramming.handsonpracticeproblems.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonConverter {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating a list of Person objects
            List<Person> people = new ArrayList<>();
            people.add(new Person("John Doe", 30, "john.doe@example.com"));
            people.add(new Person("Jane Smith", 25, "jane.smith@example.com"));
            people.add(new Person("Alice Brown", 28, "alice.brown@example.com"));

            // Converting list to JSON array
            String jsonArray = objectMapper.writeValueAsString(people);

            // Printing the JSON array
            System.out.println("JSON Array: " + jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Creating a Person class to represent Java objects
class Person {
    private String name;
    private int age;
    private String email;

    // Constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters (needed for Jackson serialization)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

