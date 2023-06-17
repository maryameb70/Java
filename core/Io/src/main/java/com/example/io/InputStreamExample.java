package com.example.io;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamExample {
    public static void main(String[] args){  // main function declaration
        byte[] array = new byte[100]; // byte array initialization
        try {// try block
            InputStream input = new FileInputStream("File.txt"); // Input Stream class object created
            System.out.println("Available bytes in the file: " + input.available());
            input.read(array); // reading byte from input stream
            System.out.println("Data read from the file: ");
            String data = new String(array); // converting byte array into string
            System.out.println(data);
            input.close(); // closing the input stream
        }
        catch (Exception e) {  // catch block
            e.getStackTrace();
        }
    }
}
