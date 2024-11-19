package com.example.envlog.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterCSV {

    // Write to CSV File Method
    public void writeCSV(String timestamp, String title, String author, String ISBN) {
        // Declare Variables
        String filePath = "";
        File fileCheck = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (fileCheck.length() == 0) {
                writer.write("Timestamp, Title, Author, ISBN");
                writer.newLine();
            }

            //Write to CSV File
            writer.write(timestamp + "," + title + "," + author + "," + ISBN);
            writer.newLine();

            System.out.println("Book Submitted Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}