package com.ioprogramming.advancedproblems.validatecsvdata;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {

    // Defining the path for the input CSV file
    private static final String INPUT_FILE = "src/main/resources/contacts.csv";

    public static void main(String[] args) {
        // Calling method to validate CSV data
        validatingCSVData(INPUT_FILE);
    }

    // Public method to validate CSV data (emails and phone numbers)
    public static void validatingCSVData(String inputFile) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";  // Email format validation regex
        String phoneRegex = "^[0-9]{10}$"; // Phone number validation (10 digits)

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            // Reading header
            String header = br.readLine();
            System.out.println(header); // Printing header

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Invalid row (Missing columns): " + line);
                    continue;
                }

                String email = data[2].trim();
                String phone = data[3].trim();

                // Validating email and phone number
                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid) {
                    System.out.println("Invalid email format: " + email + " in row: " + line);
                }
                if (!isPhoneValid) {
                    System.out.println("Invalid phone number: " + phone + " in row: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

