package com.objectfrontier.training.java.base;
public class Expression {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(1).equals(Long.valueOf(1)));
    }
}
/* 
    the expression returns false and Integer.valueOf(1) returns the integer instance representing the specified int value.
    Long.valueOf(1) returns the Long instance representing the specified Long value then finally .equals checks the two objects and returns the boolean
    flag    
*/
