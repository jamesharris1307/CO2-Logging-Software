package com.example.envlog;

// Imports
import java.util.Scanner;

public class Main {

    // Initialise Scanner
    static Scanner scn = new Scanner(System.in);
    static int portNumber = 1234;

    public static void main(String[] args) {
        // Prompt User to Enter Port Number to Connect to Server
        System.out.println("Enter Port Number: ");
        int inputPortNumb = scn.nextInt();

        if (inputPortNumb != portNumber) {
            System.out.println("Invalid Port Number");
        }else {
            //
        }


    }

}
