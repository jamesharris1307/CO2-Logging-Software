package com.example.envlog.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = null;
            boolean listening = true;

            String welcomeMsg;

            try {
                serverSocket = new ServerSocket(7777);

            }
            catch (IOException e)
            {
                System.err.println("Could not listen on port: 7777.");
                System.exit(-1);
            }

            while (listening)
                new Thread (new ClientHandler (serverSocket.accept())).start();


            serverSocket.close();
        }

}
