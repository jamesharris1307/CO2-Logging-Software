package com.example.envlog.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4873)) { // Listen on port 2222
            System.out.println("Server started on IP: " + InetAddress.getLocalHost().getHostAddress());
            while (true) {
                new Thread(new ClientHandler(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}