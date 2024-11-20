package com.example.envlog;

// Imports
import com.example.envlog.model.UserInfo;

import java.util.Scanner;
import static com.example.envlog.model.Login.login;
import static com.example.envlog.model.Register.*;
import static com.example.envlog.util.Validations.nameValidation;
import static com.example.envlog.util.Validations.usernameValidation;
import static com.example.envlog.util.Validations.passwordValidation;

public class Main {

    // Initialise Scanner
    static Scanner scn = new Scanner(System.in);
    static int portNumber = 1234;

    public static void main(String[] args) {
        // Prompt User to Enter Port Number to Connect to Server
        System.out.println("Enter Port Number: ");
        int inputPortNumb = scn.nextInt();

        while (true) {
            // Check Port Number is Correct
            if (inputPortNumb != portNumber) {
                System.out.println("Invalid Port Number");
            }else {
                break;
            }
        }

        /*
        << Connect to Server Here >>
         */

        //
        while (true) {
            System.out.println("Login (L) \n Register (R)");
            if (scn.next().equals("L")) {
                login();
                break;
            } else if (scn.next().equals("R")) {
                nameValidation();
                usernameValidation();
                passwordValidation();
                validateUserInfo();
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }

    } // Public Static Void Main End

} // Public Class Main End
