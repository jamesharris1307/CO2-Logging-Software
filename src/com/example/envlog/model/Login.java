package com.example.envlog.model;

// Imports
import java.util.Scanner;
import com.example.envlog.util.ReadCSV;

public class Login {
    // Method to Login
    public static void login(){
        // Initialise Scanner
        Scanner scn = new Scanner(System.in);
        // Declare Variables
        String input = "Please Enter ";
        String userCsvFilePath = "src/resources/UserInfo.csv";

        while (true) {
            // Prompt User to Login
            System.out.println("-- Login --");

            // Prompt User to Enter Username
            System.out.println(input + "Username: ");
            String username = scn.nextLine();

            // Prompt User to Enter Password
            System.out.println(input + "Password: ");
            String password = scn.nextLine();

            // Call Check Username and Password Method
            boolean usernamePasswordExists = ReadCSV.checkUsernamePassword(userCsvFilePath, username, password);

            // Check if Username + Password Exists
            if (usernamePasswordExists) {
                System.out.println("Login Successful");
                break;
            } else {
                System.out.println("Login Failed");
            }
        }

    } // End of Method Login

} // End of Class Login
