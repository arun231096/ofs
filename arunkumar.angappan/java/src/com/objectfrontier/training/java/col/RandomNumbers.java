package com.objectfrontier.training.java.col;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers {

    public static void main(String[] args) {

        List<Integer> randomNumbers = Arrays.asList(1, 6, 10, 25, 78);
        long sum = getSum(randomNumbers);
        log("Sum", sum);
        int max = getmax(randomNumbers);
        log("Max", max);
        int min = getmin(randomNumbers);
        log("Min", min);

    }

    private static int getmin(List<Integer> randomNumbers) {
        // TODO Auto-generated method stub
        int min = randomNumbers.stream().min(Comparator.comparing(number -> number))
                               .get();
        return min;
    }

    private static int getmax(List<Integer> randomNumbers) {
        // TODO Auto-generated method stub
        int max = randomNumbers.stream().max(Comparator.comparing(number -> number))
                               .get();
        return max;
    }

    private static long getSum(List<Integer> randomNumbers) {
        // TODO Auto-generated method stub
        long sum = randomNumbers.stream().collect(Collectors.summarizingInt(e -> e))
                                .getSum();
        return sum;
    }

    private static void log(String message, long number) {
        // TODO Auto-generated method stub
        System.out.println(message + " " +number);
    }
}
