package com.example.envlog.model;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Login {
    Scanner scn = new Scanner(System.in);
    public void login(){
        System.out.println("Login");

        System.out.println("Please enter your Username");

        String username = scn.nextLine();

        System.out.println("Please Enter your name");
        String password = scn.nextLine();

//        while(true){
//            System.out.println();
//
//            if(username.equals("admin") && password.equals("password")){
//
//                break;
//            }
//        }
//        Not sure about it
    }



}
