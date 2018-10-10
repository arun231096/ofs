// Write a program to get the number of files and number of directories in a given directory

package com.objectfrontier.training.java.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountDirAndFile {

    private Scanner in;

    public static void main(String[] args) {

        CountDirAndFile process = new CountDirAndFile();
        process.start();
    }

    private void start() {

        // get the path
        Path root = getPath();
        // count the file and directories
        countNoFilesAndDir(root);
    }

    private Path getPath() {
        in = new Scanner(System.in);
        String path = in.next();
        return Paths.get(path);
    }

    private void countNoFilesAndDir(Path root) {

        File[] totalFile = root.toFile().listFiles();
        int countfile =0;
        int countdir = 0;
        for (File in : totalFile) {
            if (in.isDirectory()) {
                countdir = countdir + 1;
            } else {
                countfile =countfile + 1;
            }
        }
        log ("No of Files in a Directory %s", countfile);
        log ("\nNo of SubDirectory in a Directory %s", countdir);
    }

    private void log(String string, int count) {
        // TODO Auto-generated method stub
        System.out.format(string, count);
    }

}
