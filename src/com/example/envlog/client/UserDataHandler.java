package com.example.envlog.client;

import com.example.envlog.service.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserDataHandler {
    static String userInput;

    static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    static String userID = Login.userId;
    

    static Scanner scn = new Scanner(System.in);

    public static void inputData(PrintWriter serverOut, BufferedReader serverIn) throws IOException {

        while(true) {
            System.out.println("Would you like to add Record or Close connection: Enter 1 or 2 \n 1) Add record \n 2) Close connection ");
            String userInputChoice = scn.nextLine();

            if (userInputChoice.equals("1")) {
                serverOut.println(userID);

                System.out.println("Please enter postcode");
                userInput = stdIn.readLine();
                serverOut.println(userInput);
                System.out.println("Server: " + serverIn.readLine());

                System.out.println("Please enter CO2");
                userInput = stdIn.readLine();
                serverOut.println(userInput);
                System.out.println("Server: " + serverIn.readLine());
            }
            else{
                System.out.println("Invalid Input");
                break;
            }
        }
    }



}
