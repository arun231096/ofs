package com.objectfrontier.training.java.base;
public class AdderFloat {

    public static void main(String[] args) throws Exception {

        if (args.length <= 1) {
            throw new Exception("Enter more then one arguments");
        }

        float sum = 0;
        for (String arg : args) {
            sum += Float.parseFloat(arg);
        }

        System.out.format("%.2f", sum);
    }
}