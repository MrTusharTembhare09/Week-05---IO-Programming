package com.ioprogramming.handsonpracticeproblems.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ValidateEmailJsonTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

    @Test
    void testValidEmailJson() {
        try {
            // Reading JSON data (Valid)
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/user.json"));
            JsonSchema jsonSchema = schemaFactory.getSchema(objectMapper.readTree(new File("src/main/resources/email-schema.json")));

            // Validating JSON data
            Set<ValidationMessage> errors = jsonSchema.validate(jsonData);

            // Asserting no errors
            assertTrue(errors.isEmpty(), "JSON data should be valid but found errors: " + errors);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testInvalidEmailJson() {
        try {
            // Reading JSON data (Invalid)
            JsonNode jsonData = objectMapper.readTree(new File("invalid-user.json"));
            JsonSchema jsonSchema = schemaFactory.getSchema(objectMapper.readTree(new File("email-schema.json")));

            // Validating JSON data
            Set<ValidationMessage> errors = jsonSchema.validate(jsonData);

            // Asserting that errors exist
            assertFalse(errors.isEmpty(), "JSON data should be invalid but found no errors.");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

