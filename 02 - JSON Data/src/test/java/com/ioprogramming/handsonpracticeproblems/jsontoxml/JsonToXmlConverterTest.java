package com.ioprogramming.handsonpracticeproblems.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverterTest {

    @Test
    void testJsonToXmlConversion() {
        try {
            // Creating ObjectMapper for JSON
            ObjectMapper jsonMapper = new ObjectMapper();

            // Reading JSON file
            JsonNode jsonNode = jsonMapper.readTree(new File("src/main/resources/data3.json"));

            // Creating XmlMapper for XML conversion
            XmlMapper xmlMapper = new XmlMapper();

            // Converting JSON to XML
            String xmlData = xmlMapper.writeValueAsString(jsonNode);

            // Asserting that XML is not empty
            assertNotNull(xmlData);
            assertFalse(xmlData.isEmpty());

        } catch (IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}

