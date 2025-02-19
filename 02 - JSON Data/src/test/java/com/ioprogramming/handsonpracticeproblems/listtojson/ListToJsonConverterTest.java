package com.ioprogramming.handsonpracticeproblems.listtojson;

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

            // Creating a list of Person objects
            List<Person> people = new ArrayList<>();
            people.add(new Person("John Doe", 30, "john.doe@example.com"));
            people.add(new Person("Jane Smith", 25, "jane.smith@example.com"));

            // Converting list to JSON array
            String jsonArray = objectMapper.writeValueAsString(people);

            // Checking if the JSON output contains expected values
            assertTrue(jsonArray.contains("John Doe"));
            assertTrue(jsonArray.contains("jane.smith@example.com"));

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

