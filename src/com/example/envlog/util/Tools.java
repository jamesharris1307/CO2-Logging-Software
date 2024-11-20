package com.example.envlog.util;

public class Tools {

    public static void convertToASCII(String[] args) {
        String input = "abc1";

        for (char letter : input.toCharArray()) {
            int asciiValue = (int) letter; // Convert Letter to it's ASCII Value
            System.out.print(asciiValue + " ");
        }

    } // End Convert to ASCII Method Static Void

    public static void main(String[] args) {
        convertToASCII(args);
    }

} // End Bracket
