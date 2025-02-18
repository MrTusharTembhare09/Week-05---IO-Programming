package com.ioprogramming.practiceproblems.carjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class CarToJsonConverter {
    public static void main(String[] args) {
        // Creating a Car object
        Car car = new Car("Tesla", "Model S", 2023);

        // Creating ObjectMapper for JSON conversion
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Converting Car object to JSON string
            String jsonString = objectMapper.writeValueAsString(car);

            // Printing JSON output
            System.out.println("Converted JSON: " + jsonString);
        } catch (IOException e) {
            System.err.println("Error converting Car to JSON: " + e.getMessage());
        }
    }
}

