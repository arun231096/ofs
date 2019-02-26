// Write a program get the permissions allowed for a file

package com.objectfrontier.training.java.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FilePermission {

    private Scanner scan;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FilePermission permissionProcess = new FilePermission();
        permissionProcess.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        // get the file path
        Path filepath = getFilepath();
        checkFilePermission(filepath);
    }

    private void checkFilePermission(Path filepath) {
        // TODO Auto-generated method stub
        File file = filepath.toFile();
        if (file.isFile()) {
            if (file.canExecute() && file.canRead() && file.canWrite()) {
                System.out.println("File has all Permission");
            } else {
                System.out.println("No permission on the file");
            }
        } else {
            System.out.println("This is not a File");
        }
    }

    private Path getFilepath() {
        scan = new Scanner(System.in);
        String path = scan.next();
        Path filepath = Paths.get(path);
        return filepath;
    }

}
