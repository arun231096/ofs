package com.objectfrontier.training.java.base;
public class Adder {

    public static void main(String[] args) {

        int c = args.length;
        int sum = 0;
            if (c > 1) {
                for(int i = 0; i < c; i++) {
                    sum += Integer.parseInt(args[i]);
                }
            System.out.println(sum);
            } else {
                System.out.println("error");
              }
    }
}
