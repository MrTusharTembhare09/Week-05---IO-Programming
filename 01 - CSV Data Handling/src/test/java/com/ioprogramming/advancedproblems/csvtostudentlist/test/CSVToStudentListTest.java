package com.ioprogramming.advancedproblems.csvtostudentlist.test;

import com.ioprogramming.advancedproblems.csvtostudentlist.CSVToStudentList;
import com.ioprogramming.advancedproblems.csvtostudentlist.Student;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVToStudentListTest {

    @Test
    void checkingStudentListSize() {
        String testFile = "test_students.csv";

        // Creating a temporary test CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("ID,Name,Age,Marks\n");
            writer.write("1,Test User1,20,80\n");
            writer.write("2,Test User2,21,85\n");
            writer.write("3,Test User3,22,90\n");
        } catch (IOException e) {
            fail("Failed to create test CSV file.");
        }

        // Reading CSV and converting to List
        List<Student> students = CSVToStudentList.convertingCSVToStudentList(testFile);

        // Checking if the list contains 3 students
        assertEquals(3, students.size());
    }
}

