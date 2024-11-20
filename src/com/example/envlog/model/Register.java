package com.example.envlog.model;

import com.example.envlog.util.Validations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Register {

    public static UserInfo createUser(String name, String Username, String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setUsername(Username);
        userInfo.setPassword(password);

        return userInfo;
    }

    public static UserInfo writer2(){

        UserInfo ur = new UserInfo();

        String name = Validations.nameValidation();
        ur.setName(name);


        String username = Validations.usernameValidation();
        ur.setUsername(username);

        String password = Validations.passwordValidation();

        ur.setPassword(password);

        return createUser(name, username, password);
    }
    public static UserInfo writer1(){

        ArrayList<UserInfo> arr = new ArrayList<>();

        UserInfo writerInfo = writer2();

        arr.add(writerInfo);
        String csv = "src/test.csv";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csv));
            writer.write("name, Username, password");
            writer.write(arr.toString());
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }
        return null;
    }

    public static void main(String[] args) {
        writer1();
    }
}
