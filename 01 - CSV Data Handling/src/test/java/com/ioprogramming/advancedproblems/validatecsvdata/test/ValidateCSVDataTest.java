package com.ioprogramming.advancedproblems.validatecsvdata.test;

import com.ioprogramming.advancedproblems.validatecsvdata.ValidateCSVData;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCSVDataTest {

    // Testing invalid email and phone number cases
    @Test
    void checkingForInvalidEmailAndPhone() {
        String testFile = "src/main/resources/test_contacts.csv";

        // Creating a temporary test CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("ID,Name,Email,Phone\n");
            writer.write("1,Test User1,invalidemail.com,12345\n");  // Invalid email & phone
            writer.write("2,Test User2,test.email@domain.com,9999999999\n");  // Valid
            writer.write("3,Test User3,user@site,888888888\n");  // Invalid email & phone
        } catch (IOException e) {
            fail("Failed to create test CSV file.");
        }

        // Running the validation method
        ValidateCSVData.validatingCSVData(testFile);

        // No assertions needed, as we are just ensuring the method runs without exceptions
    }
}
