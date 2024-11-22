package com.example.envlog.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server1 {
        public static void main(String[] args) throws IOException {
//           Initialising server socket
            ServerSocket serverSocket = null;

            boolean listening = true;

            try {
//              server socket number on port number
                serverSocket = new ServerSocket(7777);

            }
            catch (IOException e)
            {
                System.err.println("Could not listen on port: 7777.");
                System.exit(-1);
            }
//          continuously accept and creates thread for new client connection
            while (listening)
                new Thread (new ClientHandler (serverSocket.accept())).start();

            serverSocket.close();
        }

}
