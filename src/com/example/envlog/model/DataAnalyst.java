package com.example.envlog.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataAnalyst extends UserInfo{

    public DataAnalyst(String name, String username, String password) {
        super("Admin","Admin", "Admin", "Admin");
    }

    public void showCsvData(){

        String fileNameDefined = "src/resources/CO2Data.csv";
        File file = new File(fileNameDefined);

        try{

            Scanner inputStream = new Scanner(file);
            //loops line-by-line
            inputStream.nextLine();

            System.out.println("UserID,Username,Postcode,Co2,TimeStamp");
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

}

