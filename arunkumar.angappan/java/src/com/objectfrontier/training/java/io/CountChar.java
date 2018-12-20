// Write an example that counts the number of times a particular character, such as e, appears in a file.
//   The character can be specified at the command line. You can use xanadu.txt as the input file.
//
package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CountChar {

    private Reader inputFile;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        CountChar process = new CountChar();
        process.start(args[0]);// passing the char from the command line

    }

    private void start(String arg) throws IOException {
        // TODO Auto-generated method stub
        char input = arg.charAt(0);// get the char
        // get the file
        File fileToCount = new File("D:/temp/temp.txt");
        //count and print the count of char present in the file
        CountOfcharAndPrint(input, fileToCount);
    }

    private void CountOfcharAndPrint(char input, File fileToCount) throws IOException {
        // TODO Auto-generated method stub
        int count =0;
        inputFile = new FileReader(fileToCount);
        int charcter =0;
        //count the char which matches the given char
        while ((charcter = inputFile.read()) != -1) {
            char word = (char) charcter;
            if (word == input) {
                count = count + 1;
            }
        }
        System.out.println(count);
    }
}
