package com.example.envlog.server;

import com.example.envlog.util.Tools;
import com.example.envlog.util.WriteCSV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

class ClientHandler implements Runnable {
        private final Socket client;

        public ClientHandler (Socket c) {
            client = c;
        }

        WriteCSV wCSV = new WriteCSV();

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
                e.printStackTrace ();
            }
            assert outClient != null;
            outClient.println("Welcome to the server !");


            do {

                try {

                    userID = clientIn.readLine ();
//                    outClient.println (userID);

                    input = clientIn.readLine ();
                    outClient.println (input);

                    input2 = Float.parseFloat(clientIn.readLine());
                    outClient.println (input2);
                    WriteCSV.writeDataCSV(userID,input, input2);

                }

                catch (Exception e) {
                    e.printStackTrace ();
                }
//                System.out.println("Finish");
            }

            while (!Objects.equals(input, "close"));

            try {
                clientIn.close ();
                outClient.close ();
                client.close ();
            }
            catch (Exception e) {
                e.printStackTrace ();
            }
        }
}
