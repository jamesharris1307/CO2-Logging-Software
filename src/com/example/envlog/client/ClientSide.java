package com.example.envlog.client;

import com.example.envlog.service.Login;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSide {
    public static void client1() throws IOException {
//       initialising variables
        Socket server = null;
        PrintWriter serverOut = null;
        BufferedReader serverIn = null;

        String userInput;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        Scanner scn = new Scanner(System.in);

//      initialising port number variables
        int portNum;
        int actualPortNum = 1111;

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
                    serverOut.println(Login.userType);
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



        if(Login.userType == 1){
            UserDataHandler.inputData(serverOut, serverIn);
        }
        else if (Login.userType == 2) {
            while (true) {
                String menuMessage = serverIn.readLine();
                System.out.println(menuMessage);


                int userChoice = scn.nextInt();
                scn.nextLine();


                serverOut.println(userChoice);
                serverOut.flush();

                String serverResponse = serverIn.readLine();
                System.out.println(serverResponse);

                if (userChoice == 1 || userChoice == 2) {

                    String additionalData;
                    while (!(additionalData = serverIn.readLine()).isEmpty()) {
                        System.out.println(additionalData);
                    }
                } else if (userChoice == 3) {
                    break;
                }


            }
        }

        else if(Login.userType == 3) {
            while(true){
                String menuMessage = serverIn.readLine();
                System.out.println(menuMessage);

                int userChoice = scn.nextInt();

                serverOut.println(userChoice);


                String serverResponse = serverIn.readLine();
                System.out.println(serverResponse);

                if (userChoice== 1) {

                    String additionalData;
                    while (!(additionalData = serverIn.readLine()).isEmpty()) {
                        System.out.println(additionalData);
                    }
                }
                else if (userChoice == 2){
                    break;
                }

            }
            
        }

        while(true){

            System.out.println("Please input Close to exit program");
            userInput = stdIn.readLine();
            if(userInput.equals("close") || userInput.equals("Close")){
                System.out.println("Closing");
                System.out.println("Say goodbye to server");
                serverOut.close();
                serverIn.close();
                server.close();
                break;
            }

        }




    }
}
