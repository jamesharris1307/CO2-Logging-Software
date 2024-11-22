package com.example.envlog.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler (Socket c) {
            client = c;
        }

//      server side method for handling client communication
        public void run () {
            BufferedReader Inclient = null;
            PrintWriter outClient = null;
            String input = null;

//          trying to get input from the client and prints to the client anything that sends from the server
            try {
                Inclient = new BufferedReader (new InputStreamReader(client.getInputStream ()));
                outClient = new PrintWriter (client.getOutputStream (), true);
            }
            catch (Exception e) {
                e.printStackTrace ();
            }
//           Welcome message from server
            outClient.println("Welcome to the server !");

//          continuously reading clients input
            do {
                try {
                    input = Inclient.readLine ();
                    outClient.println (input);
                }
                catch (Exception e) {
                    e.printStackTrace ();
                }
            }
//          loop until input is equals to close then program should close connections
            while (!input.equals ("Close"));

            try {
                Inclient.close ();
                outClient.close ();
                client.close ();
            }
            catch (Exception e) {
                e.printStackTrace ();
            }
        }
}
