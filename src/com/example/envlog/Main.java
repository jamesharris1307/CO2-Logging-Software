package com.example.envlog;
// Imports
import com.example.envlog.client.*;
import com.example.envlog.service.RegisterUser;
import com.example.envlog.model.UserInfo;
import static com.example.envlog.service.Login.login;
import static com.example.envlog.util.WriteCSV.writeUserInfoCSV;

import java.io.IOException;
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
            if (userInput.equalsIgnoreCase("L")) {
                login(); // Execute Login Clas
                break;
            // If User Selects Register
            } else if (userInput.equalsIgnoreCase("R")) {
                RegisterUser registerUser = new RegisterUser(); // Create New Register Object
                boolean registrationSuccessful = registerUser.registerUser(); // Validate User Registration Input
                // If Registration is Successful
                if (registrationSuccessful) {
                    UserInfo userInfo = new UserInfo(registerUser.getUserId(), registerUser.getName(), registerUser.getUsername(), registerUser.getPassword()); // Get User Info
                    writeUserInfoCSV(userInfo); // Append to CSV File UserInfo.csv
                    // If User Input is not valid
                }
                else {
                    System.out.println("Invalid Input");
                }
            } else {
                System.out.println("Invalid Input");
            }
        }

        // Initialise Client
        Client cl = new Client();

        try {
            cl.client1();
            System.out.println("Finished");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // Public Static Void Main End
} // Public Class Main End
