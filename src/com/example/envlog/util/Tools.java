package com.example.envlog.util;

// Imports
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
        private static final Random random = new Random();

        public static String generateUniqueUserID() {
            String date = TimestampGenerator.generateTimestamp();
            int randomNumber = random.nextInt(9000) + 1000;
            return String.format("R%s%04d", date, randomNumber);
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
