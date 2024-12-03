package com.example.envlog.util;
import com.example.envlog.model.UserInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    // Method to Write to UserInfo CSV File
    public static void writeUserInfoCSV(UserInfo userInfo){

        // Path to the CSV File
        String userCsvFilePath = "src/resources/UserInfo.csv";
        File userInfoCSV = new File(userCsvFilePath);
        String userUniqueID = Tools.UniqueUserIDGenerator.generateUniqueUserID();

        // Create Buffered Writer to write User Input to the CSV file
        try { BufferedWriter writer = new BufferedWriter(new FileWriter(userCsvFilePath, true));

            // Write Header Row to the CSV File
            if (userInfoCSV.length() == 0) {
                writer.write("UserID, Name, Username, Password");
            }

            // Write Data Row to the CSV File
            writer.newLine();
            writer.write( userUniqueID + "," + userInfo.getName() + "," + userInfo.getUsername() + "," + userInfo.getPassword() + ",");
            writer.close();

            //Success Message
            System.out.println("Registration Successful");

            // Error Handling
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }

    } // End writeUserInfoCSV Method

    // Method to Write to Data CSV File
    public static void writeDataCSV(){

        // Path to the CSV File
        String dataCsvFilePath = "src/resources/CO2Data.csv";
        File dataInfoCSV = new File(dataCsvFilePath);
        String timeStamp = Tools.TimestampGenerator.generateTimestampFormatted();

        // Create Buffered Writer to write User Input to the CSV file
        try { BufferedWriter writer = new BufferedWriter(new FileWriter(dataCsvFilePath, true));

            // Write Header Row to the CSV File
            if (dataInfoCSV.length() == 0) {
                writer.write("Timestamp(Minute:Hour:Day:Month:Year), UserID, Postcode, Co2 Reading");
            }

            // Write Data Row to the CSV File
            writer.newLine();
            writer.write(timeStamp + "," + "userIDInput" + "," + "inputPostcode" + "," + "co2Reading");
            writer.close();

            //Success Message
            System.out.println("Input Successful");

            // Error Handling
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }

    } // End writeUserInfoCSV Method

    public static void main(String[] args) {
        // Test
        writeDataCSV();
    }

}
