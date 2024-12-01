package com.example.envlog.client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
//       initialising variables
        Socket server = null;
        PrintWriter serverOut = null;
        BufferedReader serverIn = null;

        Scanner scn = new Scanner(System.in);

//      initialising port number variables
        int portNum;
        int actualPortNum = 7777;

//     loop where user should input port number
        while (true) {
            System.out.println("Please input portNum");
            try {

                portNum = scn.nextInt();

//               if port number equal to actual port number than it will connect to server else throw exceptiond
                if (portNum == actualPortNum) {

                    server = new Socket("localhost", portNum);
                    serverOut = new PrintWriter(server.getOutputStream(), true);
                    serverIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
                    String welcome = serverIn.readLine();
                    System.out.println(welcome);
                    break;

                }
            } catch (UnknownHostException e) {
                System.err.println("Can't find localhost.");
                return;
            } catch (IOException e) {
                System.err.println("IO Error on connection to localhost/server.\n Is server running?");
                return;
            }
        }


        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        do{
            userInput = stdIn.readLine();
            serverOut.println(userInput);
            System.out.println ("Server: " + serverIn.readLine ());
        }
//        if user write close, client execution should be stopped
        while (!userInput.equals ("close"));

        serverOut.close();
        serverIn.close();
        server.close();
    }
}
