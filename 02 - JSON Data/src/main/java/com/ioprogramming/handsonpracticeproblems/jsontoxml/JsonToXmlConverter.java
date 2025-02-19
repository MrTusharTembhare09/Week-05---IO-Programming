package com.ioprogramming.handsonpracticeproblems.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Creating ObjectMapper for JSON
            ObjectMapper jsonMapper = new ObjectMapper();

            // Reading JSON file
            JsonNode jsonNode = jsonMapper.readTree(new File("src/main/resources/data3.json"));

            // Creating XmlMapper for XML conversion
            XmlMapper xmlMapper = new XmlMapper();

            // Converting JSON to XML
            String xmlData = xmlMapper.writeValueAsString(jsonNode);

            // Printing the converted XML
            System.out.println("Converted XML:\n" + xmlData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

