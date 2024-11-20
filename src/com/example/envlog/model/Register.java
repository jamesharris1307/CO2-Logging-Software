package com.example.envlog.model;

// Imports
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        userInfo.setPassword(password); // Need to Hash Password For Security Purposes
        return userInfo;

    } // End createUser Method

    // Method that gets User Info validated using the Validations.java Class
    public static UserInfo validateUserInfo(){

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

    } // End validateUserInfo Method

    // Method to Write to UserInfo CSV File
    public static void writeUserInfoCSV(UserInfo userInfo){

        // Path to the CSV File
        String userCsvFilePath = "src/resources/UserInfo.csv";
        File userInfoCSV = new File(userCsvFilePath); // Check if the File Exists

        // Create Buffered Writer to write User Input to the CSV file
        try { BufferedWriter writer = new BufferedWriter(new FileWriter(userCsvFilePath, true));

            // Write Header Row to the CSV File
            if (userInfoCSV.length() == 0) {
                writer.write("Name, Username, Password");
            }

            // Write Data Row to the CSV File
            writer.newLine();
            writer.write(userInfo.getName() + "," + userInfo.getUsername() + "," + userInfo.getPassword() + ",");
            writer.close();

            //Success Message
            System.out.println("Registration Successful");

            // Error Handling
        } catch (IOException ioe) {
            System.out.println("Couldn't write to file");
        }

    } // End writeUserInfoCSV Method

    public static void registerUser() {
        validateUserInfo();
    }

}