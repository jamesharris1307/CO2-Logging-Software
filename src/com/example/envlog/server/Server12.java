package com.example.envlog.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server12 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket( 8081);

        Socket input = serverSocket.accept();

        Scanner in = new Scanner(input.getInputStream());

        while(in.hasNext()){

            writeToCsv writer1 = new writeToCsv();

            System.out.println(in.nextLine());
            writer1.writer2("1","2","3");

        }
        in.close();
        input.close();
        serverSocket.close();
//        try{
//
//        }
//        catch(Exception e){
//
//        }
    }
}
