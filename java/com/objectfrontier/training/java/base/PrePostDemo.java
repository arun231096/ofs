package com.objectfrontier.training.java.base;
class PrePostDemo {

    public static void main(String[] args){

        int i = 3;
        i++;
        System.out.println(i);    // "4"
        ++i;
        System.out.println(i);    // "5"
        System.out.println(++i);  // "6"
        System.out.println(i++);  // "6"    //initially in prints the 'i' value as 6 then post increment is incremented and printed on the next line
        System.out.println(i);    // "7"
    }
}
