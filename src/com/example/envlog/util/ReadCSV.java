package com.example.envlog.util;

// Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSV {
    // Method to check if User Input Username Exists in UserInfo CSV File
    public static boolean checkUsernameExists(String filePath, String username) {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the Header Line at top of CSV File

            // Search each line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split line into fields
                if (data.length > 1) {
                    String storedUsername = data[1].trim(); // Username is index 1 as its second field in csv file
                    if (storedUsername.equals(username)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error Reading File" + e.getMessage());
        }
        return false;
    }

    public static boolean checkPasswordExists(String filePath, String password) {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the Header Line at top of CSV File

            // Search each line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split line into fields
                if (data.length > 1) {
                    String storedPassword = data[2].trim(); // Password is index 2 as its second field in csv file
                    if (storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error Reading File" + e.getMessage());
        }
        return false;
    }
}
