package com.example.envlog.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCSV {
    public static boolean checkUsernameExists(String filePath, String username) {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                if (line.trim().equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error Reading File" + e.getMessage());
        }
        return false;
    }
}
