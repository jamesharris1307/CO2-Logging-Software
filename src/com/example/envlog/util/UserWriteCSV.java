package com.example.envlog.util;

import com.example.envlog.model.UserInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserWriteCSV {
    // Method to Write to UserInfo CSV File
    public static void writeUserInfoCSV(UserInfo userInfo){

        // Path to the CSV File
        String userCsvFilePath = "src/resources/UserInfo.csv";
        File userInfoCSV = new File(userCsvFilePath); // Check if the File Exists

        // Create Buffered Writer to write User Input to the CSV file
        try { BufferedWriter writer = new BufferedWriter(new FileWriter(userCsvFilePath, true));

            // Write Header Row to the CSV File
            if (userInfoCSV.length() == 0) {
                writer.write("Name, Username, Password");
            }

            // Write Data Row to the CSV File
            writer.newLine();
            writer.write(userInfo.getName() + "," + userInfo.getUsername() + "," + userInfo.getPassword() + ",");
            writer.close();

            //Success Message
            System.out.println("Registration Successful");

            // Error Handling
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }

    } // End writeUserInfoCSV Method
}
