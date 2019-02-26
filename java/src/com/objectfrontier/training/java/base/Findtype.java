package com.objectfrontier.training.java.base;
public class Findtype {

    public static void main(String[] args) {
        
        Object obj = 100 / 24;
        System.out.println(obj.getClass().getSimpleName());
        obj = 100.10 / 10;
        System.out.println(obj.getClass().getSimpleName());
        obj = 'Z' / 2;
        System.out.println(obj.getClass().getSimpleName());
        obj = 10.5 / 0.5;
        System.out.println(obj.getClass().getSimpleName());
        obj = 12.4 % 5.5;
        System.out.println(obj.getClass().getSimpleName());
        obj = 100 % 56;
        System.out.println(obj.getClass().getSimpleName());
    }
}
/* 
    Automatic conversion happened when mixing primitive with respective Wrapper types for the above operations which is Auto Boxing
*/
