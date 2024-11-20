package com.example.envlog.util;

// Imports
import java.util.Scanner;
// Import Validations.java Class
import com.example.envlog.util.Tools;

// Validations Class that contains methods that validates User Info
public class Validations {

    // UserInput Variables
    static String name;
    static String username;
    static String password;

    // Validate Input Messages
    static String input = "Please Enter ";
    static String error = "Input Error - ";
    static String invalid = "Try Again: ";

    // Initialise Scanner
    static Scanner scn = new Scanner(System.in);

    // Method to Validate UserInput (Name)
    public static String nameValidation() {

        // Loop Until UserInput (Name) is Validated
        while (true) {
            // Ask User for Input
            System.out.println(input + "name: ");
            name = scn.nextLine(); // Take Input

            // Check if Input is Empty
            if (name.isEmpty()) {
                System.out.println(error + "Name Can't Be Empty \n" + invalid);
            } else {
                break;
            }
        }
        // Return UserInput after Validated
        return name;
    }

    // Method to Validate UserInput (Username)
    public static String usernameValidation() {

        // Loop Until UserInput (Username) is Validated
        while (true) {
            // Ask User for Input
            System.out.println(input + "Username: ");
            username = scn.nextLine(); // Take Input

            // Check if Input is Empty or Less than 5 Characters
            if (username.length() < 5) {
                System.out.println(error + "Username Less than 5 Characters \n" + invalid);
            } else {
                break;
            }
        }
        return username;
    }

    // Method to Validate UserInput (Password)
    public static String passwordValidation() {

        // Loop Until UserInput (Password) is Validated
        while (true) {
            System.out.println(input + "Password: ");
            password = scn.nextLine();

            // Check if Input is Empty or Less than 8 Characters
            if (password.length() < 8) {
                System.out.println(error + "Password too short minimum 8 characters \n"  + invalid);
            } else if (!password.matches(".*\\d.*")) {
                System.out.println(error + "Password must contain at least one number (0-9) \n"  + invalid);
            } else
                // I guess we could Hash Password Here
                break;
        }
        return password;
    }

} // End of Public Class Validations
