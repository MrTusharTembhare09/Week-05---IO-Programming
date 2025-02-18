package com.ioprogramming.advancedproblems.csvtostudentlist;

import java.io.*;
import java.util.*;

public class CSVToStudentList {

    // Defining the path for the input CSV file
    private static final String INPUT_FILE = "src/main/resources/students.csv";

    public static void main(String[] args) {
        // Calling method to read CSV and convert it into a list of Student objects
        List<Student> students = convertingCSVToStudentList(INPUT_FILE);

        // Printing student details
        students.forEach(System.out::println);
    }

    // Public method to read CSV file and convert to a List of Student objects
    public static List<Student> convertingCSVToStudentList(String inputFile) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            // Skipping header row
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 4) continue; // Skipping invalid rows

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                int marks = Integer.parseInt(data[3].trim());

                // Creating Student object and adding to list
                studentList.add(new Student(id, name, age, marks));
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }

        return studentList;
    }
}



