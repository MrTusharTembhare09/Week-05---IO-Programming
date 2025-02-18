package com.ioprogramming.advancedproblems.encryptdecryptcsv.main;

import com.ioprogramming.advancedproblems.encryptdecryptcsv.utils.AESCryptoUtil;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EncryptCSVWriter {
    private static final String FILE_NAME = "src/main/resources/employees_encrypted.csv";

    public static void main(String[] args) {
        // Creating employee data
        List<String[]> employees = Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary", "Email"},
                new String[]{"101", "Rahul Sharma", "IT", encryptData("70000"), encryptData("rahul@gmail.com")},
                new String[]{"102", "Priya Verma", "HR", encryptData("65000"), encryptData("priya@yahoo.com")},
                new String[]{"103", "Amit Kumar", "Finance", encryptData("75000"), encryptData("amit@outlook.com")}
        );

        // Writing encrypted data to CSV
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (String[] row : employees) {
                writer.write(String.join(",", row) + "\n");
            }
            System.out.println("✅ Encrypted CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Encrypting data
    private static String encryptData(String data) {
        try {
            return AESCryptoUtil.encrypt(data);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
}

