package com.ioprogramming.handsonpracticeproblems.iplcensoranalyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IPLCensorAnalyzer {

    // Censoring team names
    private static String censorTeamName(String team) {
        String[] words = team.split(" ");
        if (words.length > 1) {
            return words[0] + " ***";
        }
        return team;
    }

    // Processing JSON file
    public static void processJsonFile(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(inputFile));

        for (JsonNode node : rootNode) {
            ((ObjectNode) node).put("team1", censorTeamName(node.get("team1").asText()));
            ((ObjectNode) node).put("team2", censorTeamName(node.get("team2").asText()));
            ((ObjectNode) node).put("player_of_match", "REDACTED");
        }

        objectMapper.writeValue(new File(outputFile), rootNode);
    }

    // Processing CSV file
    public static void processCsvFile(String inputFile, String outputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        List<String> processedLines = new ArrayList<>();

        if (!lines.isEmpty()) {
            processedLines.add(lines.get(0)); // Keep header
            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                parts[1] = censorTeamName(parts[1]); // Censor team1
                parts[2] = censorTeamName(parts[2]); // Censor team2
                parts[6] = "REDACTED"; // Censor Player of the Match
                processedLines.add(String.join(",", parts));
            }
        }

        Files.write(Paths.get(outputFile), processedLines);
    }

    public static void main(String[] args) {
        try {
            processJsonFile("src/main/resources/ipl_data.json", "ipl_censored.json");
            processCsvFile("src/main/resources/ipl_data.csv", "ipl_censored.csv");
            System.out.println("Censorship applied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
