package com.example.envlog.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = null;
            boolean listening = true;

            String welcomeMsg;

            try {
                serverSocket = new ServerSocket(1111);

            }
            catch (IOException e)
            {
                System.err.println("Could not listen on port: 2222.");
                System.exit(-1);
            }

            while (listening)
                new Thread (new ClientHandler (serverSocket.accept())).start();

            serverSocket.close();
        }

}
