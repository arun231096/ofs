package com.objectfrontier.training.java.base;
public class NumberHolder {

        public int anInt;
        public float aFloat;

        public static void main(String[] args) {

            NumberHolder holder =  new NumberHolder();
            holder.anInt = 20;
            holder.aFloat = 30.4f;
            System.out.println(holder.anInt);
            System.out.println(holder.aFloat);
    }
}
