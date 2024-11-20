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

        public void run () {
            BufferedReader clientIn = null;
            PrintWriter outClient = null;
            String input = null;

            try {
                clientIn = new BufferedReader (new InputStreamReader(client.getInputStream ()));
                outClient = new PrintWriter (client.getOutputStream (), true);
            }
            catch (Exception e) {
                e.printStackTrace ();
            }
            outClient.println("Welcome to the server !");
            do {
                try {
                    input = clientIn.readLine ();
                    outClient.println (input);
                }
                catch (Exception e) {
                    e.printStackTrace ();
                }
            }
            while (!input.equals ("Close"));

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
