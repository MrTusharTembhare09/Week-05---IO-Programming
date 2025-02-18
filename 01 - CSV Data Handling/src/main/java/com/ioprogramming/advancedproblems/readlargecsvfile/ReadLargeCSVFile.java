package com.ioprogramming.advancedproblems.readlargecsvfile;

import java.io.*;

public class ReadLargeCSVFile {
    private static final String CSV_FILE = "src/main/resources/sample_large.csv";
    private static final int CHUNK_SIZE = 5; // Processing 5 lines at a time (For testing)

    public static void main(String[] args) {
        readingCSVInChunks(CSV_FILE, CHUNK_SIZE);
    }

    // Public method to read a CSV file in chunks
    public static void readingCSVInChunks(String filePath, int chunkSize) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            // Skipping the header row
            reader.readLine();
            System.out.println("Processing CSV in chunks...");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;

                // When chunkSize records are processed, simulate batch processing
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + count + " records so far...");
                    System.out.println("---------------------------");
                }
            }

            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

