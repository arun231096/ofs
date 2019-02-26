package com.objectfrontier.training.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadCsv {

    public static void main(String[] args) {

        ReadCsv readProcess = new ReadCsv();
        readProcess.start();
    }

    private void start() {
        // TODO Auto-generated method stub
        Path path = Paths.get("C:/Users/arunkumar.angappan/Downloads/OFS.csv");
        try {
            List <String> readLines = Files.readAllLines(path);
            printCsv(readLines);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void printCsv(List<String> readLines) {
        // TODO Auto-generated method stub
        readLines.forEach(line -> System.out.println(line));
    }
}
