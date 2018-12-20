package com.objectfrontier.training.java.base;
public class TestSample {

    public static void main(String[] args) {

        TestSample ts = new TestSample();
        ts.testCondition();
    }

    void testCondition() {

        int aNumber =3;
        if (aNumber >= 0){
            if (aNumber == 0) {
                System.out.println("first string");
            }
        } else {
            System.out.println("second string");
        }
        System.out.println("third string");
    }
}
/*  output :-  third string */
