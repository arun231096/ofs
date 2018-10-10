// Write a program to convert InputStream to String and vice versa

package com.objectfrontier.training.java.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConvertInput {

    private BufferedReader data;
    private InputStream in;
    public static void main(String[] args) throws IOException {

        ConvertInput process = new ConvertInput();
        // convert the Inputstream to string
        String data = process.convertToString();
        // convert the string to Inputstream
        process.CovertToInputStream(data);
    }

    private String convertToString() throws IOException {
        // TODO Auto-generated method stub
        // get the data from the user
        in = System.in;
        data = new BufferedReader(new InputStreamReader(in));
        String input = data.readLine();
        System.out.println("InputStream to String \n" + input);
        data.close();
        return input;
    }

    private void CovertToInputStream(String input) throws IOException {

        // convert the string to InputStream
        in = new ByteArrayInputStream(input.getBytes());
        printStreamData(in);
        in.close();
    }

    private void printStreamData(InputStream data) {
        // TODO Auto-generated method stub
        int c = 0;
        System.out.println("String to InputStream");
        // printing the data in the inputstream
        while (c != -1) {
            try {
                c = data.read();
                System.out.print((char)c);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
