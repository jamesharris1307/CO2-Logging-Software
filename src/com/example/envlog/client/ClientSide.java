package com.example.envlog.client;

import com.example.envlog.service.Login;

import java.io.*;
import java.net.*;
import java.util.Queue;
import java.util.Scanner;

public class ClientSide {
    public static void client1() throws IOException {
        // initialising variables
        Socket server = null;
        PrintWriter serverOut = null;
        BufferedReader serverIn = null;

        String userInput;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        Scanner scn = new Scanner(System.in);

        // initialising port number variables
        int portNum;
        int actualPortNum = 2222;
        String serverIp = null;

        //loop where user should input port number
        while (true) {
            System.out.println("Please Input Port Number:");
            try {
                portNum = scn.nextInt();
                scn.nextLine();

                if (portNum == actualPortNum) {
                    // Loop to retry entering the correct IP address
                    while (true) {
                        System.out.println("Please Input Server IP Address:");
                        serverIp = scn.nextLine();

                        // Ensure input is not empty
                        if (serverIp.isEmpty()) {
                            System.out.println("Server IP Address cannot be empty. Please try again.");
                            continue; // Prompt the user to try again
                        }

                        try {
                            // Attempt to connect to the server
                            server = new Socket(serverIp, portNum);
                            serverOut = new PrintWriter(server.getOutputStream(), true);
                            serverIn = new BufferedReader(new InputStreamReader(server.getInputStream()));

                            String welcome = serverIn.readLine();
                            System.out.println(welcome);
                            serverOut.println(Login.userType);
                            break; // Exit IP input loop upon successful connection
                        } catch (UnknownHostException e) {
                            System.err.println("Invalid Server IP Address. Please try again.");
                        } catch (IOException e) {
                            System.err.println("IO Error on connection to server. Is the server running? Please try again.");
                        }
                    }
                    break; // Exit port number loop after successful connection
                } else {
                    System.out.println("Incorrect Port Number. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a numeric port number.");
                scn.nextLine(); // Clear invalid input
            }
        }

        if(Login.userType == 1){
            UserDataHandler.inputData(serverOut, serverIn);
        }
        else if (Login.userType == 2) {
            while (true) {
                String menuMessage = serverIn.readLine();
                System.out.println(menuMessage);

                int userChoice = scn.nextInt();
                scn.nextLine();
                serverOut.println(userChoice);
                serverOut.flush();
                String serverResponse = serverIn.readLine();
                System.out.println(serverResponse);

                if (userChoice == 1 || userChoice == 2) {
                    String additionalData;
                    while (!(additionalData = serverIn.readLine()).isEmpty())
                    {
                        System.out.println(additionalData);
                    }
                } else if (userChoice == 3) {
                    break;
                }
            }
        }
        else if(Login.userType == 3) {
            while(true){
                String menuMessage = serverIn.readLine();
                System.out.println(menuMessage);
                int userChoice = scn.nextInt();
                serverOut.println(userChoice);
                String serverResponse = serverIn.readLine();
                System.out.println(serverResponse);

                if (userChoice== 1) {
                    String additionalData;
                    while (!(additionalData = serverIn.readLine()).isEmpty()) {
                        System.out.println(additionalData);
                    }
                } else if (userChoice == 2){
                    break;
                }
            }
        }

        while(true){
            System.out.println("Please Input Close to Exit Program");
            userInput = stdIn.readLine();
            if(userInput.equalsIgnoreCase("Close")){
                System.out.println("Closing");
                serverOut.close();
                serverIn.close();
                server.close();
                break;
            }
        }
    }
}
