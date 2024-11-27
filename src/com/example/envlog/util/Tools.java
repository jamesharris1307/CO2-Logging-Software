package com.example.envlog.util;

// Imports
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tools {

    // Method to Generate Current Timestamp
    public static String generateTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return now.format(formatter);
    } // End Generate Timestamp

    // Get Timestamp Value
    public String getTimestamp() {
        return generateTimeStamp();
    }

    // Create a Unique User ID
    public static class UniqueUserIDGenerator {
        private static Random random = new Random();

        public static String generateUniqueUserID() {
            String date = generateTimeStamp();
            int randomNumber = random.nextInt(9000) + 1000;

            return String.format("R%s%04d", date, randomNumber);
        }
    }

    // Test Methods
    public static void main(String[] args) {
        System.out.println(generateTimeStamp());
        System.out.println(UniqueUserIDGenerator.generateUniqueUserID());
        System.out.println(UniqueUserIDGenerator.generateUniqueUserID());
    }


} // End Bracket
