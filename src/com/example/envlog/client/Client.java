package com.example.envlog.client;

import com.example.envlog.service.Login;
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
        int actualPortNum = 1234;

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
//                    String input = serverIn.readLine();
//                    System.out.println(input);
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


        String userID = Login.userId;

        while(true) {
            System.out.println("Would you like to add Record or Close connection: Enter 1 or 2 \n 1) Add record \n 2) Close connection ");
            int num = scn.nextInt();

            if (num == 1) {
                serverOut.println(userID);

                System.out.println("Please enter postcode");
                userInput = stdIn.readLine();
                serverOut.println(userInput);
                System.out.println("Server: " + serverIn.readLine());

                System.out.println("Please enter CO2");
                userInput = stdIn.readLine();
                serverOut.println(userInput);
                System.out.println("Server: " + serverIn.readLine());

            } else {
                // close, client execution should be stopped
                serverOut.close();
                serverIn.close();
                server.close();
                break;
            }
        }



    }
}
