package com.objectfrontier.training.java.base;
class NumberHolder1 {

        public int anInt;
        public float aFloat;
}

public class AssignVarables {

    public static void main(String[]args) {

        NumberHolder1 holder =  new NumberHolder1();
        holder.anInt = 20;
        holder.aFloat = 30.4f;
        System.out.println(holder.anInt);
        System.out.println(holder.aFloat);
    }
}
