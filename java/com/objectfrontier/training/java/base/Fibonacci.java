package com.objectfrontier.training.java.base;
public class Fibonacci {

    public static void main(String[] args) {

        Fibonacci fibbo = new Fibonacci();
        fibbo.usingWhileLoop();
        fibbo.usingForLoop();
        System.out.println(0);
        fibbo.usingRecursive(0, 1, 10);
    }
    
    void usingWhileLoop(){

        
        int first = 0;
        int second = 1;
        int calculatefibbo = 0;
        int iteration =0;
        System.out.println(first);
        System.out.println(second);
        while (iteration < 10){
            calculatefibbo = first + second;
            first = second;
            second = calculatefibbo;
            System.out.println(calculatefibbo);
            iteration++;
        }
    }

    void usingForLoop() {

        int first = 0;
        int second = 1;
        int calculatefibbo = 0;
        System.out.println(first);
        System.out.println(second);
        for(int i=0; i < 10; i++){
            calculatefibbo = first + second;
            first = second;
            second = calculatefibbo;
            System.out.println(calculatefibbo);
        }
    }

    void usingRecursive (int a, int b, int count) {

        if (count > 0) {
            int c = a + b;
            a = b;
            b = c;
            System.out.println(c + " ");
            usingRecursive (a,b,count - 1);
        }
    }
}
