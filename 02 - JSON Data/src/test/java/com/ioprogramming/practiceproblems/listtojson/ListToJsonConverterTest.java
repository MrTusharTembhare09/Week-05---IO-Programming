package com.ioprogramming.practiceproblems.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListToJsonConverterTest {

    @Test
    void testListToJsonConversion() {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Creating a list of Student objects
            List<ListToJsonConverter.Student> students = new ArrayList<>();
            students.add(new ListToJsonConverter.Student("Alice", 22, "alice@example.com"));
            students.add(new ListToJsonConverter.Student("Bob", 24, "bob@example.com"));

            // Converting the list to a JSON array
            String jsonArray = objectMapper.writeValueAsString(students);

            // Checking if JSON is correctly formatted
            assertTrue(jsonArray.contains("Alice"));
            assertTrue(jsonArray.contains("Bob"));
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

