package com.example.envlog.util;

import java.util.Scanner;

// Validations Class that contains methods that validates User Info
public class Validations {

    // Declare Variables
    static String invalid = "Try Again: ";

    // Validate UserInput (Name)
    public static String nameValidation() {
        // Initialise Scanner
        Scanner scn = new Scanner(System.in);
        String valName; // Name Variable

        // Loop Until UserInput (Name) is Validated
        while (true) {
            // Ask User for Input
            System.out.println("Please enter name");
            valName = scn.nextLine(); // Take Input

            // Check if Input is Empty
            if (valName.isEmpty()) {
                System.out.println("Name Can't Be Empty \n" + invalid);
            } else {
                break;
            }
        }
        // Return UserInput after Validated
        return valName;
    }

    public static String usernameValidation() {

        Scanner scn = new Scanner(System.in);

        String username;

        while (true) {

            System.out.println("Please enter Username");
            username = scn.nextLine();

            if (username.isEmpty() || username.length() < 5) {
                System.out.println("You cant leave Username empty \n  PLease try again: ");
            } else {
                break;
            }
        }


        return username;
    }

    public static String passwordValidation() {

        Scanner scn = new Scanner(System.in);

        String password;

        while (true) {
            System.out.println("PLease enter Password");
            password = scn.nextLine();

            if (password.isEmpty()) {
                System.out.println("Password is empty or to short min 8char \n Please try again");
            } else if (password.length() < 8) {
                System.out.println("Password to short min 8char \n Please try again");
            } else if (!password.matches(".*\\d.*")) {
                System.out.println("Password must contain at least one number \n Please try again");
            } else
                break;
        }
        return password;
    }
}
