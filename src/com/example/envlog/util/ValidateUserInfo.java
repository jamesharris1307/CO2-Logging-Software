package com.example.envlog.util;

public class ValidateUserInfo {

    // Validate Name
    public boolean validateName(String name) {
        // Check if Input is Empty
        if (name.isEmpty()) {
            System.out.println("Name Can't Be Empty");
            return false;
        } else {
            return true;
        }
    }

    // Validate userName
    public boolean validateUsername(String username) {
        // Check if Input is Empty or Less than 5
        if (username.length() < 5) {
            System.out.println("Username too short minimum 5 Characters");
            return false;
        } else {
            return true;
        }
    }

    // Validate Password
    public boolean validatePassword(String password) {
        // Check if Input is Empty or Less than 8 Characters
        if (password.length() < 8) {
            System.out.println("Password too short minimum 8 characters");
            return false;
        } else if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one number (0-9)");
            return false;
        } else {
            return true;
        }
    }
} // End Validate User Info
