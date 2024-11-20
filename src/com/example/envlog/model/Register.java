package com.example.envlog.model;

// Imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
// Import Validations.java Class
import com.example.envlog.util.Validations;

//Register Class Contains Methods for Creating a user, validating UserInput and Creating/Storing UserInput in a CSV File
public class Register {

    // Method that creates a UserInfo object
    public static UserInfo createUser(String name, String Username, String password){
        // Create User Info Object
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setUsername(Username);
        userInfo.setPassword(password);
        return userInfo;
    }

    // User Info is validated using the Validations.java Class
    public static UserInfo writer2(){

        // Create validateUserInfo
        UserInfo validateUserInfo = new UserInfo();
        // Validate Name
        String name = Validations.nameValidation();
        validateUserInfo.setName(name);
        // Validate Username
        String username = Validations.usernameValidation();
        validateUserInfo.setUsername(username);
        // Validate Password
        String password = Validations.passwordValidation();
        validateUserInfo.setPassword(password);
        // Return Validated User Input
        return createUser(name, username, password);
    }

    public static UserInfo writer1(){
        // Create an Array List
        ArrayList<UserInfo> arr = new ArrayList<>();
        // Collect User Info
        UserInfo writerInfo = writer2();
        // Add UserInfo to ArrayList
        arr.add(writerInfo);
        // Path to the CSV File
        String csv = "src/UserInfo.csv";

        try {
            // Create Buffered Writer to write User Input to the CSV file
            BufferedWriter writer = new BufferedWriter(new FileWriter(csv, true)); // Adding 'true' makes the file append not overwrite.
            // Write Header Row to the CSV File
            writer.write("Name, Username, Password");
            // User Input gets written on a new line
            writer.newLine();
            // Write Data Stored in Array List to the CSV File
            writer.write(arr.toString());
            // Close Writer
            writer.close();
            // Error Handling
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }
        return null;
    }

    // Calling 'Writer1'
    public static void main(String[] args) {
        writer1();
    }
}