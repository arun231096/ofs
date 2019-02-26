package com.objectfrontier.training.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileUsingPath {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReadFileUsingPath process = new ReadFileUsingPath();
        process.start();

    }

    private void start() {
        // TODO Auto-generated method stub
        // get the path of the file
        Path filepath = Paths.get("D:/temp/temp.txt");
        try {
            // Read the file using InputStream
            InputStream readFile = filepath.toUri().toURL().openStream();
            // display the content of the file
            displayFileContent(readFile);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void displayFileContent(InputStream readFile) {
        // TODO Auto-generated method stub
        int read = 0;
        // print the content by single characters
        while (read != -1) {
            try {
                read = readFile.read();
                System.out.print((char)read);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
