package com.example.envlog.util;

// Imports
import com.example.envlog.service.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Tools {

    // Method to Generate Current Timestamp
    public static class TimestampGenerator {
        public static String generateTimestamp() {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            return now.format(formatter);
        }

        public static String generateTimestampFormatted() {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:HH:dd:MM:yyyy");
            return now.format(formatter);
        }
    }

    // Create a Unique User ID
    public static class UniqueUserIDGenerator {
        private static Random random = new Random();

        public static String generateUniqueUserID() {
            String date = TimestampGenerator.generateTimestamp();
            int randomNumber = random.nextInt(9000) + 1000;
            return String.format("R%s%04d", date, randomNumber);
        }
    }

    public static class UserInputData {

//        Login login = new Login();

//        login.login();


        public static String inputPostcode;

        public static float co2Reading;

        static String userID = Login.userId;
        public static String userInputData() throws IOException {

            Scanner reader = new Scanner(System.in);

//            System.out.println(userID);
            System.out.println("Input Postcode: ");
            inputPostcode = reader.nextLine();
            System.out.println("Input CO2 Reading: ");
            co2Reading = reader.nextFloat();

            return userID +","+ inputPostcode+"," + co2Reading;
        }

    }

    // Test Methods
    public static void main(String[] args) {
        System.out.println(TimestampGenerator.generateTimestamp());
        System.out.println(TimestampGenerator.generateTimestampFormatted());
        System.out.println(UniqueUserIDGenerator.generateUniqueUserID());
        System.out.println(UniqueUserIDGenerator.generateUniqueUserID());
//        System.out.println(UserInputData.userInputData());
    }


} // End Bracket
