package com.example.io;

import java.io.OutputStream;

public class FileOutputStream {
    public static void main(String[] args) {
        String data = "Hello Readers!! Welcome to TutorialsPoint"; // string variable storing line to be written in File.txt
        try {  // try block
            OutputStream out = new java.io.FileOutputStream("File.txt"); // Output Stream class object created
            byte[] dataBytes = data.getBytes(); // Converts the string into bytes
            out.write(dataBytes); // Writes data to the output stream
            System.out.println("Data is written to the file.");
            out.close(); // Closes the output stream
        }
        catch (Exception e) {  // catch block
            e.getStackTrace();
        }
    }
}
