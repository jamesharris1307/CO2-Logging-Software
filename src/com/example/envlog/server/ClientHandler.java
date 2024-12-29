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
import static java.lang.System.out;

class ClientHandler implements Runnable {
    private final Socket client;

    public ClientHandler(Socket c) {
        client = c;
    }

    //Run method
    public void run() {
        // Initialising variables
        BufferedReader clientIn = null;
        PrintWriter outClient = null;
        String input = null;
        Float input2;
        String userID;

        try {
        // Getting client input
            clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // Print something to the client
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
                    if (userID == null) {
                        break;
                    }

                    input = clientIn.readLine();
                    if (input == null) {
                        break;
                    }

                    outClient.println(input);

                    // Read the float input
                    String inputLine = clientIn.readLine();
                    if (inputLine == null) {
                        break;
                    }

                    try {
                        input2 = Float.valueOf(inputLine);
                    } catch (NumberFormatException e) {
                        outClient.println("Invalid CO2 value. Please enter a valid number.");
                        continue;
                    }

                    outClient.println(input2);
                    WriteCSV.writeDataCSV(userID, input, input2);
                }
            } else if (typerC == 2) {
                while (true) {
                    outClient.println("Would You Like to: (1) View User Info (2) View CSV Data (3) Close Program");
                    String clientChoiceStr = clientIn.readLine();

                    int clientChoice;

                    try {
                        clientChoice = Integer.parseInt(clientChoiceStr);
                    } catch (NumberFormatException e) {
                        outClient.println("Invalid option. Please Enter a Number (1, 2, or 3).");
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
                    outClient.println("Would you like to: (1) View CSV Data (2) Close program");
                    String clientChoiceStr = clientIn.readLine();
                    int clientChoice;

                    try {
                        clientChoice = Integer.parseInt(clientChoiceStr);
                    } catch (NumberFormatException e) {
                        outClient.println("Invalid option. Please Enter a Number (1 or 2).");
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
                            outClient.println("Invalid Option. Try again.");
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
