package com.ioprogramming.practiceproblems.carjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarToJsonConverterTest {
    @Test
    void testCarToJson() throws Exception {
        // Creating ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating a sample Car object
        Car car = new Car("Toyota", "Corolla", 2022);

        // Converting Car object to JSON string
        String jsonString = objectMapper.writeValueAsString(car);

        // Verifying JSON contains expected fields
        assertTrue(jsonString.contains("\"brand\":\"Toyota\""));
        assertTrue(jsonString.contains("\"model\":\"Corolla\""));
        assertTrue(jsonString.contains("\"year\":2022"));
    }
}

