//Write some String content to a file using appropriate OutputStream

package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFile {

    private OutputStream out;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WriteFile createFile = new WriteFile();
        createFile.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        String content = "This is my first text file writing using OutputStream.";
        File newFile = new File("D:/temp/tempfile.txt");
        try {

            if (!newFile.exists()) {// creating the new file if not exist

                newFile.createNewFile();
                out = new FileOutputStream(newFile);// make the file is writable
                out.write(content.getBytes());// writing the content on the file
                System.out.println("Inserted");
            } else {

                out = new FileOutputStream(newFile);// make the file is writable
                out.write(content.getBytes());// writing the content on the file
                System.out.println("Inserted");
            }
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
