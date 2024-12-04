package com.example.envlog.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInfo {
    private final String userId;
    private final String name;
    private final String username;
    private final String password;

    public UserInfo(String userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {return userId;}

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return userId + "," + name + "," + username + "," + password;
    }

    public static void showCsvData() {

        String fileNameDefined = "src/resources/CO2Data.csv";
        File file = new File(fileNameDefined);

        try {

            Scanner inputStream = new Scanner(file);
            //loops line-by-line
            inputStream.nextLine();

            System.out.println("TimeStamp,UserID,Postcode,Co2(ppm)");
            while (inputStream.hasNext()) {

//              reading line by line and print this data in to console
                String data = inputStream.next();
                System.out.println(data);

            }
            //  close scanner
            inputStream.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        }
    }
}


