package com.example.envlog;

// Imports
import com.example.envlog.service.RegisterUser;
import com.example.envlog.model.UserInfo;
import static com.example.envlog.service.Login.login;
import static com.example.envlog.util.WriteCSV.writeUserInfoCSV;
import java.util.Scanner;

public class Main {

    // Initialise Scanner
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        // Prompt User to Register or to Login
        while (true) {
            System.out.println("Login (L)\nRegister (R)");
            String userInput = scn.nextLine();

            // If User Selects Login
            if (userInput.equals("L")) {
                login(); // Execute Login Class
                break;
            // If User Selects Register
            } else if (userInput.equals("R")) {
                RegisterUser registerUser = new RegisterUser(); // Create New Register Object
                boolean registrationSuccessful = registerUser.registerUser(); // Validate User Registration Input

                // If Registration is Successful
                if (registrationSuccessful) {
                    UserInfo userInfo = new UserInfo(registerUser.getName(), registerUser.getUsername(), registerUser.getPassword()); // Get User Info
                    writeUserInfoCSV(userInfo); // Append to CSV File UserInfo.csv

                    // If User Input is not valid
                } else {
                    System.out.println("Invalid Input");
                }
            }
        }


        // << Initialise Client >>

        // << Connect to Server Here >>

        // Print Hello Message

        // Prompt User to Enter CO2 Readings Info

        // Validate User Input

        // If Statement
            //Successfully Validated - Send to CSV File
        // Else
            //Unsuccessfully Validated - Print Error Message

    } // Public Static Void Main End
} // Public Class Main End
