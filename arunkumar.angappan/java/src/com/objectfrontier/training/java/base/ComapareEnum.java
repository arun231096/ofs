package com.objectfrontier.training.java.base;
enum Week {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
}

public class ComapareEnum {

    public static void main(String[] args) {

        Week w1 = Week.Friday;
        Week w2 = Week.Monday;
        Week w3 = w1;
        System.out.println(w1 == w3);
        System.out.println(w1.equals(w3));
        System.out.println(w1.equals(w2));
        System.out.println(w1 == w2);
    }
}
