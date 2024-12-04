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
                if (data.length > 4) {
                    String storedUsername = data[3].trim(); // Username is Index 2
                    String storedPassword = data[4].trim(); // Password is Index 3
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

//    Method for fetching userId on the logging phase
    public static String fetchUserId(String filePath, String username, String password){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
//           while loop through csv file
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
//                checking username, password and returning userid
                if(parts.length > 4 && parts[3].equals(username) && parts[4].equals(password)){
                    return parts[1];
                }
            }
        }catch (IOException e){
            System.out.println("Error reading CSV file" + e.getMessage());
        }
        return "Not Found";
    }

    public static String fetchUserType(String filePath, String username, String password){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            br.readLine();
//           while loop through csv file
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
//                checking username, password and returning userid
                if(parts.length > 4 && parts[3].equals(username) && parts[4].equals(password)){
                    return parts[0];
                }
            }
        }catch (IOException e){
            System.out.println("Error reading CSV file" + e.getMessage());
        }
        return "Not Found";
    }

}
