// program get the file names of all file with specific extension in a directory

package com.objectfrontier.training.java.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileDetails {

    private Scanner scanner;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FileDetails details = new FileDetails();
        details.getFileType();
    }

    private void getFileType() {
        // TODO Auto-generated method stub
        File[] listOfFiles = getFileDetails();
        printFileDetails(listOfFiles);
    }

    private void printFileDetails(File[] listOfFiles) {
        // TODO Auto-generated method stub
        for (File singleFile : listOfFiles) {
            if (singleFile.isFile()) {
                System.out.println(singleFile.getName());
            }
        }
    }

    private File[] getFileDetails() {
        // TODO Auto-generated method stub
        Path rootpath = getRootPath();
        File root = rootpath.toFile();
        File[] listofFiles = root.listFiles();
        return listofFiles;
    }

    private Path getRootPath() {
        scanner = new Scanner(System.in);
        String path = scanner.next();
        Path rootpath = Paths.get(path);
        if (rootpath.isAbsolute()) {
        return rootpath;
        } else {
            System.out.println("Please Give Valid Path");
            System.exit(0);
            return null;
        }
    }

}
