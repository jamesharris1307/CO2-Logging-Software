package com.example.envlog.server;

import com.example.envlog.util.WriteCSV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

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
        float input2;
        String userID;

        try {
            //Getting client input
            clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //Print something to the client
            outClient = new PrintWriter(client.getOutputStream(), true);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assert outClient != null;
        outClient.println("Welcome to the server !");

        do {
            try {
                userID = clientIn.readLine();

                input = clientIn.readLine();
                outClient.println(input);

                input2 = Float.parseFloat(clientIn.readLine());
                outClient.println(input2);
                WriteCSV.writeDataCSV(userID, input, input2);

                input = clientIn.readLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (!Objects.equals(input, "close"));
        try {
            clientIn.close();
            outClient.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
