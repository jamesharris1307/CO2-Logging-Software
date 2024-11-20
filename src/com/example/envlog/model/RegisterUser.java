package com.example.envlog.model;

// Imports
import java.util.Scanner;

public class RegisterUser {

    public static void inputInfo() {
        // Initialise Scanner
        Scanner scn = new Scanner(System.in);
        // Declare Variables
        String input = "Please Enter ";
        String userCsvFilePath = "src/resources/UserInfo.csv";

        // Prompt User to Register
        System.out.println("-- Register --");

        // Prompt User to Enter Name
        System.out.println(input + "Name: ");
        String Name = scn.nextLine();

        // Prompt User to Enter Username
        System.out.println(input + "Username: ");
        String username = scn.nextLine();

        // Prompt User to Enter Password
        System.out.println(input + "Password: ");
        String password = scn.nextLine();



    }
}
