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

        // Prompt User to Login
        System.out.println("-- Login --");

        // Prompt User to Enter Username
        System.out.println(input + "Username: ");
        String username = scn.nextLine();

        // Prompt User to Enter Password
        System.out.println(input + "Password: ");
        String password = scn.nextLine();

        // Call Check Username Method
        boolean usernameExists = ReadCSV.checkUsernameExists(userCsvFilePath, username);

        if (usernameExists){
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        scn.close();

    } // End of Method Login

    public static void main(String[] args) {
        login();
    }

} // End of Class Login
