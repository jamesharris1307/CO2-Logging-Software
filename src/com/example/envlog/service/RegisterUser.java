package com.example.envlog.service;

// Imports
import java.util.Scanner;

import com.example.envlog.util.Tools;
import com.example.envlog.util.ValidateUserInfo;

public class RegisterUser {

    private String name;
    private String username;
    private String password;

    public boolean registerUser() {
        // Initialise Scanner
        Scanner scn = new Scanner(System.in);
        // Declare Variables
        String input = "Please Enter ";

        // Initialize ValidateUserInfo class
        ValidateUserInfo validate = new ValidateUserInfo();

        // Use a while loop to keep asking for user input if validation fails
        boolean isValid = false;
        while (!isValid) {
            // Prompt User to Register
            System.out.println("-- Register --");

            // Prompt User to Enter Name
            System.out.println(input + "Name: ");
            this.name = scn.nextLine();

            // Prompt User to Enter Username
            System.out.println(input + "Username: ");
            this.username = scn.nextLine();

            // Prompt User to Enter Password
            System.out.println(input + "Password: ");
            this.password = scn.nextLine();

            // Validate Input
            isValid = validate.validateName(name) && validate.validateUsername(username) && validate.validatePassword(password);

            // If validation fails, print an error and repeat the loop
            if (!isValid) {
                System.out.println("Registration failed. Please check your input and try again.");
            }
        }
        // If we exit the loop, the input is valid
        System.out.println("Registration successful!");
        return true;
    }

    // Getter methods to access private fields
    public String getUserId() {
        return Tools.UniqueUserIDGenerator.generateUniqueUserID();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
