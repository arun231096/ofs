// program to convert InputStream  Object to inputStream and vice versa

package com.objectfrontier.training.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ObjectToStream {

    private InputStream in;
    public static void main(String[] args) throws IOException {

        ObjectToStream convertProcess = new ObjectToStream();
        convertProcess.start();
    }

    private void start() throws IOException {
        // TODO Auto-generated method stub
        convertObjecttoStream();
        convertStreamtoObject();
    }

    private void convertStreamtoObject() throws IOException {
        // TODO Auto-generated method stub
        String input = "Hello all";
        in = new ByteArrayInputStream(input.getBytes());
        Object convertedStream = new StringBuffer();
        int data = 0;
        while (data != -1) {
            data = in.read();
            ((StringBuffer) convertedStream).append((char) data);
        }
        System.out.println("\nInputStream To Object");
        System.out.println(convertedStream.toString());
    }

    private void convertObjecttoStream() throws IOException {
        // TODO Auto-generated method stub
        Object input = "Hello all";
        in = new ByteArrayInputStream(input.toString().getBytes());
        printStreamData(in);
    }

    private void printStreamData(InputStream data) {
        // TODO Auto-generated method stub
        int c = 0;
        System.out.println("Object to InputStream");
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
