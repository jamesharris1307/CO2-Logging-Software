package com.example.envlog.model;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clientSocket {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1",8081);

        PrintWriter out = new PrintWriter(socket.getOutputStream());

        System.out.println("Please enter your Name");

        Scanner scn = new Scanner(System.in);

        String name = scn.nextLine();

        out.println(name);

        out.close();
        socket.close();
    }
}
