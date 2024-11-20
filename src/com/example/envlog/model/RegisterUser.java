package com.example.envlog.model;

// Imports
import java.util.Scanner;

public class RegisterUser {

    public static void registerUser() {
        // Initialise Scanner
        Scanner scn = new Scanner(System.in);
        // Declare Variables
        String input = "Please Enter ";
        String userCsvFilePath = "src/resources/UserInfo.csv";

        // Prompt User to Register
        System.out.println("-- Register --");

        // Prompt User to Enter Name
        System.out.println(input + "Name: ");
        String name = scn.nextLine();

        // Prompt User to Enter Username
        System.out.println(input + "Username: ");
        String username = scn.nextLine();

        // Prompt User to Enter Password
        System.out.println(input + "Password: ");
        String password = scn.nextLine();

        /*
        // Print Inputted Info
        System.out.println(name + username + password);

         */
    }



    public static void main(String[] args) {
        registerUser();
    }

}
