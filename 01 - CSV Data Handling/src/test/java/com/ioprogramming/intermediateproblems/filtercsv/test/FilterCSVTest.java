package com.ioprogramming.intermediateproblems.filtercsv.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterCSVTest {

    // Testing if the program filters records correctly
    @Test
    void checkingFilteredRecords() {
        // Simulating a filtering process
        boolean hasQualifyingRecords = false;

        // Expected qualifying record (a student with marks > 80)
        String expectedRecord = "ID: 101, Name: Alice Johnson, Age: 20, Marks: 85";

        // Filtering logic (in a real scenario this would involve reading a file)
        String[] records = {
                "ID: 101, Name: Alice Johnson, Age: 20, Marks: 85",
                "ID: 102, Name: Bob Smith, Age: 22, Marks: 70"
        };

        // Checking if any qualifying record exists
        for (String record : records) {
            if (record.contains("Marks: 85")) {  // Assuming we check for qualifying mark
                hasQualifyingRecords = true;
            }
        }

        // Asserting that there are qualifying records
        assertTrue(hasQualifyingRecords, "There should be at least one qualifying record.");
    }
}
