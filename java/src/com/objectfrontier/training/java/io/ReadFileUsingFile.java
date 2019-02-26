package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class ReadFileUsingFile {

    public static void main(String[] args) throws MalformedURLException, IOException {

        ReadFileUsingFile process = new ReadFileUsingFile();
        process.start();
    }

    private void start() throws MalformedURLException, IOException {
        // TODO Auto-generated method stub
        InputStream readChar = loadFile();
        printReadedContent(readChar);
    }

    private InputStream loadFile() {
        // TODO Auto-generated method stub
        File toRead =  new File("D:/temp/temp.txt");
        InputStream readchar;
        try {
            readchar = toRead.toURI().toURL().openStream();
            return readchar;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private void printReadedContent(InputStream readchar) {
        // TODO Auto-generated method stub
        int read = 0;
        while (read != -1) {
            try {
                read = readchar.read();
                System.out.print((char)read);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
