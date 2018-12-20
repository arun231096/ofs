package com.objectfrontier.training.java.base;
class ClassA {
    public void methodOne(int i) {
    }
    public void methodTwo(int i) {
    }
    public static void methodThree(int i) {
    }
    public static void methodFour(int i) {
    }
}

class ClassB extends ClassA {
/*    public static void methodOne(int i) {
    }
    public void methodTwo(int i) {
    }
    public void methodThree(int i) {
    }
*/    public static void methodFour(int i) {
    }
}

public class InheritClass {

    public static void main(String[] args) {

        ClassA override = new ClassB();
        override.methodTwo(10); // a)methodTwo()overrides a methodTwo() in the superclass
        override.methodTwo(20); // b)methodTwo() hides a methodTwo() in the superclass
        /* c) Other method is declared as a static in superclass  and subclass so it throws the compile time error*/
    }
}
