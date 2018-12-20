package com.objectfrontier.training.java.col;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupDuplicateRemoval {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Integer> randomNumbers = Arrays.asList(1, 6, 10, 1, 25, 78, 10, 25);
        List<Integer> duplicateRemovedList = removeduplicate(randomNumbers);
        log(duplicateRemovedList);
    }

    private static List<Integer> removeduplicate(List<Integer> randomNumbers) {
        // TODO Auto-generated method stub

        List<Integer> duplicateRemovedList = randomNumbers.stream().distinct().collect(Collectors.toList());
        return duplicateRemovedList;
    }

    private static void log(List<Integer> numberList) {
        // TODO Auto-generated method stub
        numberList.forEach(input -> System.out.println(input));
    }
}
