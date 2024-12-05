package com.example.envlog.client;

import com.example.envlog.model.Admin;
import com.example.envlog.model.DataAnalyst;
import com.example.envlog.service.Login;
import com.example.envlog.util.ReadCSV;
import com.example.envlog.util.Tools;
import com.example.envlog.util.WriteCSV;

import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
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
        int actualPortNum = 3333;

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

        ReadCSV rCSV = new ReadCSV();

        String cl;

        if(Login.userType == 1){
            userAuthorisation.inputData(serverOut, serverIn);
        }
            else if(Login.userType == 2) {
                System.out.println("Admin");
                while(true) {
                    System.out.println("Would you like to show user (data)information or show Co2 data: Enter 1 or 2 or 3 \n 1) Show user (data)information \n 2) Show Co2 data \n 3) To exit" );
                    int num = scn.nextInt();
                    if(num==1) {
                        Admin.showUserInfo();
                    } else if (num==2) {
                        Admin.showCsvData();
                    }
                    else{
                        break;
                    }

                }

            }
        else if(Login.userType == 3) {
            System.out.println("Analyst");
            while(true) {
                System.out.println("Would you like to show user (data)information or show Co2 data: Enter 1 or 2  \n 1) Show Co2 data \n 2) Close" );
                int num = scn.nextInt();
                if(num==1) {
                    DataAnalyst.showCsvData();
                } else if (num==2) {
                   break;
                }

            }

        }

        while(true){

            System.out.println("Please input Close to exit program");
            userInput = stdIn.readLine();
            if(userInput.equals("close") || userInput.equals("Close")){
                System.out.println("Closing");
                serverOut.close();
                serverIn.close();
                server.close();
                break;
            }

        }




    }
}
