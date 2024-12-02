package com.example.envlog.util;

// Imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    // Method to check if User Input Username Exists in UserInfo CSV File
    public static boolean checkUsernamePassword(String filePath, String username, String password) {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the Header Line at top of CSV File

            // Search each line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Split line into fields
                if (data.length > 2) {
                    String storedUsername = data[1].trim(); // Username is Index 1
                    String storedPassword = data[2].trim(); // Password is Index 2
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error Reading File" + e.getMessage());
        }
        return false;
    }

    public static String fetchUserId(String filePath, String username, String password){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts[1].equals(username) && parts[2].equals(password)){
                    return parts[0];
                }
            }
        }catch (IOException e){
            System.out.println("Error reading CSV file" + e.getMessage());
        }
        return null;
    }
}
