package com.example.envlog;

// Imports
import com.example.envlog.model.RegisterUser;
import com.example.envlog.util.UserWriteCSV;
import com.example.envlog.model.UserInfo;

import java.util.Scanner;
import static com.example.envlog.model.Login.login;


public class Main {

    // Initialise Scanner
    static Scanner scn = new Scanner(System.in);
    static int portNumber = 1234;

    public static void main(String[] args) {
        // Prompt User to Enter Port Number to Connect to Server
        System.out.println("Enter Port Number: ");
        int inputPortNumb = scn.nextInt();
        scn.nextLine();

        while (true) {
            // Check Port Number is Correct
            if (inputPortNumb != portNumber) {
                System.out.println("Invalid Port Number");
                scn.nextLine();
            } else {
                break;
            }
        }

        /*
        << Connect to Server Here >>
         */

        while (true) {
            System.out.println("Login (L)\nRegister (R)");
            String userInput = scn.nextLine();

            if (userInput.equals("L")) {
                login();
                break;
            } else if (userInput.equals("R")) {
                RegisterUser registerUser = new RegisterUser();
                boolean registrationSuccessful = registerUser.registerUser();

                if (registrationSuccessful) {
                    System.out.println("Registration Successful!");

                    // Get the user info from RegisterUser after successful registration
                    String name = registerUser.getName();
                    String username = registerUser.getUsername();
                    String password = registerUser.getPassword();

                    UserInfo userinfo = new UserInfo(name, username, password);
                    UserWriteCSV.writeUserInfoCSV(userInfo);
                    break;
                } else {
                    System.out.println("Invalid Input");
                }
            }

        } // Public Static Void Main End
    }
} // Public Class Main End
