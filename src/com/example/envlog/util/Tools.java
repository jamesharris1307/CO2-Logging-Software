package com.example.envlog.util;

// Imports
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tools {

    // Method to Generate Current Timestamp
    public static String generateTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return now.format(formatter);
    } // End Generate Timestamp

    // Get Timestamp Value
    public String getTimestamp() {
        return generateTimeStamp();
    }

    // Method to Convert String to ASCII
    public static void convertToASCII(String input) {
        for (char letter : input.toCharArray()) {
            int asciiValue = (int) letter; // Convert Letter to it's ASCII Value
            System.out.print(asciiValue + " ");
        }

    } // End Convert to ASCII Method Static Void

    // Test Methods
    public static void main(String[] args) {
        String testInput = "ASCII";
        System.out.println(generateTimeStamp());
        convertToASCII(testInput);
    }

} // End Bracket
