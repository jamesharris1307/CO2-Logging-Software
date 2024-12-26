package com.example.envlog.server;

import com.example.envlog.model.Admin;
import com.example.envlog.model.DataAnalyst;
import com.example.envlog.util.WriteCSV;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.out;

class ClientHandler implements Runnable {
    private final Socket client;

    public ClientHandler(Socket c) {
        client = c;
    }

    //Run method
    public void run() {
//          Initialising variables
        BufferedReader clientIn = null;
        PrintWriter outClient = null;
        String input = null;
        float input2;
        String userID;

        try {
//              Getting client input
            clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
//              Print something to the client
            outClient = new PrintWriter(client.getOutputStream(), true);
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        assert outClient != null;
        outClient.println("Welcome to the server !");

        try {
            int typerC = Integer.parseInt(clientIn.readLine());

            if (typerC == 1) {
                while (true) {
                    userID = clientIn.readLine();

                    input = clientIn.readLine();
                    outClient.println(input);

                    Scanner reader = new Scanner(clientIn); // Try Scanner Instead of Buffered Reader because scanner reads a float (nextFloat) while buffered reader reads String (readLine).

                    input2 = reader.nextFloat();

                    //input2 = Float.parseFloat(clientIn.readLine()); // !! Error, when close connection to Server, Float is Assigned Null Value (Causes Null Pointer Exception) !!
                    outClient.println(input2);

                    WriteCSV.writeDataCSV(userID, input, input2);
                }
            } else if (typerC == 2) {
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
            } else if (typerC == 3) {
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
                            break;
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
                input = clientIn.readLine();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }

        while (!Objects.equals(input, "close"));
        try {
            clientIn.close();
            outClient.close();
            client.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
