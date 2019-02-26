//Read a any text file using BufferedReader and print the content of the file

package com.objectfrontier.training.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private FileReader readFile;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReadFile read = new ReadFile();
        read.theFileAndPrint();
    }

    private void theFileAndPrint() {
        // TODO Auto-generated method stub
        // Get the file
        File file = new File("D:/temp/sudocode.txt");
        try {
            // read the file
            readFile = new FileReader(file);
            BufferedReader reader = new BufferedReader(readFile);
            // get the lines from the file
            String content = reader.readLine();
            while (content != null) {
                // display the content of the file
                System.out.println(content);
                content = reader.readLine();
            }
            reader.close();
            readFile.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
