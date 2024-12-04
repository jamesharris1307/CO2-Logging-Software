package com.example.envlog.service;

// Imports
import java.util.Objects;
import java.util.Scanner;
import com.example.envlog.util.ReadCSV;

public class Login {

    public static String userId;

    public static int userType;
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

            userId = ReadCSV.fetchUserId(userCsvFilePath, username, password);

            userType = Integer.parseInt(Objects.requireNonNull(ReadCSV.fetchUserType(userCsvFilePath, username, password)));

            // Check if Username + Password Exists
            if (usernamePasswordExists) {
                System.out.println("Login Successful");
                break;
            } else {
                System.out.println("Login Failed. Invalid Username or Password");
            }
        }

    } // End of Method Login

} // End of Class Login
