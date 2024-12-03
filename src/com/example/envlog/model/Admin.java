package com.example.envlog.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Admin extends UserInfo{

    public Admin(String userId, String name, String username, String password) {
        super(userId, "Admin", "Admin", "Admin");
    }

    public void showUserInof(){

        String fileNameDefined = "src/resources/UserInfo.csv";
        File file = new File(fileNameDefined);

        try{

            Scanner inputStream = new Scanner(file);
            //loops line-by-line
            inputStream.nextLine();

            System.out.println("UserID,Name,Username,Password");
            while(inputStream.hasNext()){

//              reading line by line and print this data in to console
                String data = inputStream.next();
                System.out.println(data.toString());

            }
            //  close scanner
            inputStream.close();


        }catch (FileNotFoundException e){

            e.printStackTrace();
        }

    }

        public static void main(String[] args) {

    }



}
