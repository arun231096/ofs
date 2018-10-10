// program to check if two paths are same

package com.objectfrontier.training.java.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathComparison {

    public static void main(String[] args) {

        PathComparison paths = new PathComparison();
        paths.compare();
    }

    private void compare() {
        // TODO Auto-generated method stub
        Path path1 = Paths.get("D:/temp/");
        Path path2 = Paths.get("D:/temp");
        int result = path1.compareTo(path2);
        if (result == 0) {
            System.out.println("Paths are Same");
        } else {
            System.out.println("Paths are diffrent");
        }
    }
}
