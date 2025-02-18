package com.ioprogramming.advancedproblems.encryptdecryptcsv.main;

import com.ioprogramming.advancedproblems.encryptdecryptcsv.utils.AESCryptoUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecryptCSVReader {
    private static final String FILE_NAME = "src/main/resources/employees_encrypted.csv";

    public static void main(String[] args) {
        // Reading the encrypted CSV file and decrypting data
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals("ID")) { // Skipping header
                    data[3] = decryptData(data[3]); // Decrypting Salary
                    data[4] = decryptData(data[4]); // Decrypting Email
                }
                System.out.println(String.join(", ", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Decrypting data
    private static String decryptData(String data) {
        try {
            return AESCryptoUtil.decrypt(data);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
}

