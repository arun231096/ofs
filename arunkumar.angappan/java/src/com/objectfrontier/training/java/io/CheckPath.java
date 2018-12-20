// Given a path, check if path is file or directory
package com.objectfrontier.training.java.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CheckPath {

    private Scanner in;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CheckPath path = new CheckPath();
        // checking the path
        path.check();
    }

    private void check() {
        // TODO Auto-generated method stub
        // get the path
        Path pathroot = getPath();
        // check the path is file or directory
        checkFileOrDirectory(pathroot);
    }

    private void checkFileOrDirectory(Path pathroot) {
        // TODO Auto-generated method stub
        if (Files.notExists(pathroot)) { // Checking path is valid path or the path is exist
            System.out.println("Not a valid Path " + pathroot);
        } else if (Files.isDirectory(pathroot)) {// checking path contains file if contain file display message
            System.out.println("It is Directory");
        } else {
            System.out.println("This is File"); // printing the path is directory
        }
    }

    private Path getPath() {
        in = new Scanner(System.in);
        String path = in.next();
        Path pathroot = Paths.get(path);
        return pathroot;
    }

}
