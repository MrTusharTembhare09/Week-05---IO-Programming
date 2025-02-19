package com.ioprogramming.handsonpracticeproblems.iplcensoranalyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class IPLCensorAnalyzerTest {
    @Test
    void testCensorship() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File inputFile = new File("src/test/resources/ipl_data.json");
            JsonNode rootNode = objectMapper.readTree(inputFile);

            for (JsonNode match : rootNode) {
                assertFalse(match.get("team1").asText().contains("Indians"));
                assertFalse(match.get("team2").asText().contains("Super Kings"));
                assertEquals("REDACTED", match.get("player_of_match").asText());
            }
        } catch (IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testCSVProcessing() {
        try {
            File outputFile = new File("src/test/resources/ipl_data.csv");
            assertTrue(outputFile.exists(), "Censored CSV file should be created.");
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
