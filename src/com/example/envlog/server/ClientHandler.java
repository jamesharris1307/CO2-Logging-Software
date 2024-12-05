package com.example.envlog.server;

import com.example.envlog.model.Admin;
import com.example.envlog.model.DataAnalyst;
import com.example.envlog.service.Login;
import com.example.envlog.util.Tools;
import com.example.envlog.util.WriteCSV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler (Socket c) {
            client = c;
        }

        WriteCSV wCSV = new WriteCSV();

        Tools.UserInputData tu = new Tools.UserInputData();

        Scanner scn = new Scanner(System.in);

//Run method
        public void run () {
//          Initialising variables
            BufferedReader clientIn = null;
            PrintWriter outClient = null;
            String input = null;
            float input2;
            String userID;

            try {
//              Getting client input
                clientIn = new BufferedReader (new InputStreamReader(client.getInputStream ()));
//              Print something to the client
                outClient = new PrintWriter (client.getOutputStream (), true);
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace ();
            }
            outClient.println("Welcome to the server !");



            int typerC = 0;

            try {
                typerC = Integer.parseInt(clientIn.readLine());

                if(typerC == 1){
                    userID = clientIn.readLine ();

                    input = clientIn.readLine ();
                    outClient.println (input);

                    input2 = Float.parseFloat(clientIn.readLine());
                    outClient.println (input2);
                    wCSV.writeDataCSV(userID,input, input2);

                }

                else if(typerC == 2){
                    while (true) {
                        outClient.println("Would you like to show user (data) information or show CO2 data: Enter 1, 2, or 3: 1) Show User Information; 2)Show CSV data; 3) Close program");

                        String clientChoiceStr = clientIn.readLine();

                        int clientChoice;
                        try {
                            clientChoice = Integer.parseInt(clientChoiceStr);
                        } catch (NumberFormatException e) {
                            outClient.println("Invalid option. Please enter a number (1, 2, or 3).");
                            continue;
                        }



                            switch (clientChoice) {
                                case 1:
                                    String userInfo = Admin.showUserInfo();
                                    outClient.println(userInfo);
                                        break;
                                case 2:
                                    String userInfo2 = Admin.showCsvData();
                                    outClient.println(userInfo2);
                                        break;
                                case 3:
                                    outClient.println("Exiting.");
                                        break;
                                default:

                                    outClient.println("Invalid option. Try again.");
                                    outClient.flush();
                                    break;
                            }
                    }

                }

                else if (typerC == 3){
                    while (true) {
                        outClient.println("Would you like to show user (data) information or show CO2 data: Enter 1, 2: 1)Show Csv data; 2)Close program");

                        String clientChoiceStr = clientIn.readLine();

                        int clientChoice;

                        try {
                            clientChoice = Integer.parseInt(clientChoiceStr);
                        } catch (NumberFormatException e) {
                            outClient.println("Invalid option. Please enter a number (1 or 2).");
                            outClient.flush();
                            continue;
                        }


                        switch (clientChoice) {
                            case 1:

                                String userInfo = DataAnalyst.showCsvData();
                                outClient.println(userInfo);
                            case 2:
                                break;
                            default:
                                outClient.println("Invalid option. Try again.");
                                outClient.flush();
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            do {
                try {

                    input = clientIn.readLine ();
                }

                catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace ();
                }

            }


            while (!input.equals ("close"));

            try {
                clientIn.close ();
                outClient.close ();
                client.close ();
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace ();
            }
        }
}
