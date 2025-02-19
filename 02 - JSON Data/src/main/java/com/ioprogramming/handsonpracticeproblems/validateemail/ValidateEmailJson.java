package com.ioprogramming.practiceproblems.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.SpecVersion;

import java.io.File;
import java.util.Set;

public class ValidateEmailJson {
    public static void main(String[] args) {
        try {
            // Creating an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading JSON data
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/user.json"));

            // Loading JSON schema (Fixed)
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema jsonSchema = schemaFactory.getSchema(objectMapper.readTree(new File("src/main/resources/email-schema.json")));

            // Validating JSON data
            Set<ValidationMessage> errors = jsonSchema.validate(jsonData);

            // Printing validation result
            if (errors.isEmpty()) {
                System.out.println("✅ JSON data is valid!");
            } else {
                System.out.println("❌ JSON validation errors:");
                errors.forEach(error -> System.out.println(error.getMessage()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



