package com.example.envlog.client;

import com.example.envlog.util.Tools;
import com.example.envlog.util.WriteCSV;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void client1() throws IOException {
//       initialising variables
        Socket server = null;
        PrintWriter serverOut = null;
        BufferedReader serverIn = null;

        Tools tools1 = new Tools();

        Tools.UserInputData userInp = new Tools.UserInputData();

        Scanner scn = new Scanner(System.in);

//      initialising port number variabless
        int portNum;
        int actualPortNum = 7777;

//     loop where user should input port number
        while (true) {
            System.out.println("Please input portNum");
            try {

                portNum = scn.nextInt();

//               if port number equal to actual port number than it will connect to server else throw exception
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

        WriteCSV wrt = new WriteCSV();



        do{
//            userInp.userInputData();
            wrt.writeDataCSV();
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
