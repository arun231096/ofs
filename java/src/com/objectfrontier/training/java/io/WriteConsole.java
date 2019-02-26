//Write some String content to console using appropriate Writer

package com.objectfrontier.training.java.io;

import java.io.Console;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteConsole {

    private Scanner scanContent;
    private PrintWriter writter;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        WriteConsole console = new WriteConsole();
        String content = console.getContent();//  get the string content
        console.writeString(content);// print into the console
    }

    private String getContent() {
        scanContent = new Scanner(System.in);
        String content = scanContent.nextLine();
        return content;
    }

    private void writeString(String content) {

        Console cons = System.console();
        if (cons != null) {
        writter = cons.writer().append(content);
        writter.println();
        } else {
            System.out.println("No Console Access");
        }
    }

}
