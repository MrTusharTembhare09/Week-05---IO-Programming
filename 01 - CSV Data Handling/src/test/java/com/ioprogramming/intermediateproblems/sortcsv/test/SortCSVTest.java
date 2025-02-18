package com.ioprogramming.intermediateproblems.sortcsv.test;

import com.ioprogramming.intermediateproblems.sortcsv.SortCSV;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortCSVTest {

    // Testing if sorting maintains descending salary order
    @Test
    void checkingIfSalariesAreSortedCorrectly() {
        // Fetching sorted records using public method
        List<String[]> sortedRecords = SortCSV.sortingAndDisplayingTopSalaries("src/main/resources/employees.csv");

        // Checking if salaries are sorted in descending order
        for (int i = 0; i < sortedRecords.size() - 1; i++) {
            double currentSalary = Double.parseDouble(sortedRecords.get(i)[3]);
            double nextSalary = Double.parseDouble(sortedRecords.get(i + 1)[3]);
            assertTrue(currentSalary >= nextSalary, "Salaries should be sorted in descending order.");
        }
    }
}

