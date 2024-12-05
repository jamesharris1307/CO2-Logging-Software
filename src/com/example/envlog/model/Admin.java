package com.example.envlog.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Admin extends UserInfo{



    public Admin(String userId, String name, String username, String password) {
        super(userId, "Admin", "Admin", "Admin");
    }

    public static String showUserInfo() {
        StringBuilder dataBuilder = new StringBuilder();
        String fileNameDefined = "src/resources/UserInfo.csv";
        File file = new File(fileNameDefined);

        try (Scanner inputStream = new Scanner(file)) {

            // Skip the header line (or you can include it if you want)
            if (inputStream.hasNextLine()) {
                dataBuilder.append(inputStream.nextLine()).append("\n");
            }

            // Read the entire file line by line
            while (inputStream.hasNextLine()) {
                String data = inputStream.nextLine();  // Read one line at a time
                dataBuilder.append(data).append("\n");  // Append each line to the StringBuilder

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dataBuilder.toString();
    }
}
