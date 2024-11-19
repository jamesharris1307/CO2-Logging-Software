package com.example.envlog.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterCSV {

    // Write to CSV File Method
    public void writeCSV(String timestamp, String userID, String postcode, String concentration) {
        // Declare Variables
        String filePath = ""; // Need to add the file path of the csv file (Alternative - we could have the program create one if one does not exist)
        File fileCheck = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (fileCheck.length() == 0) {
                writer.write("Timestamp, userID, postcode, concentration"); // Only variable that exists is Timestamp -
                                                                                // userID, postcode, concentration collected from user input (Client Side)
                writer.newLine();
            }

            // Write to CSV File
            writer.write(timestamp + "," + userID + "," + postcode + "," + concentration);
            writer.newLine();

            // Print a message saying Reading was Submitted Successfully
            System.out.println("Reading Submitted Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}