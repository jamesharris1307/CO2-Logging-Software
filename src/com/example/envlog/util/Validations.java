package com.example.envlog.util;

import java.util.Scanner;

public class Validations {

    public static String nameValidation() {

        Scanner scn = new Scanner(System.in);

        String name;

        while (true) {

            System.out.println("Please enter name");
            name = scn.nextLine();

            if (name.isEmpty()) {
                System.out.println("You cant leave Name empty \n  PLease try again: ");
            } else {
                break;
            }
        }


        return name;
    }

    public static String usernameValidation() {

        Scanner scn = new Scanner(System.in);

        String username;

        while (true) {

            System.out.println("Please enter Username");
            username = scn.nextLine();

            if (username.isEmpty() || username.length() < 5) {
                System.out.println("You cant leave Username empty \n  PLease try again: ");
            } else {
                break;
            }
        }


        return username;
    }

    public static String passwordValidation() {

        Scanner scn = new Scanner(System.in);

        String password;

        while (true) {
            System.out.println("PLease enter Password");
            password = scn.nextLine();

            if (password.isEmpty()) {
                System.out.println("Password is empty or to short min 8char \n Please try again");
            } else if (password.length() < 8) {
                System.out.println("Password to short min 8char \n Please try again");
            } else if (!password.matches(".*\\d.*")) {
                System.out.println("Password must contain at least one number \n Please try again");
            } else
                break;
        }
        return password;
    }
}
