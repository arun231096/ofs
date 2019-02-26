package com.objectfrontier.training.java.base;
public class OverloadWithWrapper {

    public static void main(String[] args) {

        OverloadWithWrapper olw = new OverloadWithWrapper();
        olw.printWrapperType(10);
        olw.printWrapperType(10, 23.888);
        olw.printWrapperType(10.44, 23.22F);
        olw.printWrapperType(10, 10.44F, 23.55, 'A');
    }
    void printWrapperType(Integer first) {
        System.out.println("Overloading One : "+first);
    }

    void printWrapperType(Integer first, Double second) {

        System.out.println("Overloading second : "+first);
        System.out.println("Overloading second : "+second);
    }

    void printWrapperType(Double first, Float second) {

        System.out.println("Overloading third : "+first);
        System.out.println("Overloading third : "+second);
    }

    void printWrapperType(Integer first, Float second, Double third, Character word) {

        System.out.println("Overloading four : "+first);
        System.out.println("Overloading four : "+second);
        System.out.println("Overloading four : "+third);
        System.out.println("Overloading four : "+word);
    }
}