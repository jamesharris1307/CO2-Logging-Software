package com.example.envlog.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin extends UserInfo{



    public Admin(String userId) {
        super(userId, "Admin", "Admin", "Admin");
    }

    public static void showUserInfo(){

        String fileNameDefined = "src/resources/UserInfo.csv";
        File file = new File(fileNameDefined);

        try{

            Scanner inputStream = new Scanner(file);
            //loops line-by-line
            inputStream.nextLine();

            System.out.println("UserType,UserID,Name,Username,Password");
            while(inputStream.hasNext()){

//              reading line by line and print this data in to console
                String data = inputStream.next();
                System.out.println(data);

            }
            //  close scanner
            inputStream.close();


        }catch (FileNotFoundException e){
            System.out.println("File not found" + e.getMessage());
        }

    }


}
