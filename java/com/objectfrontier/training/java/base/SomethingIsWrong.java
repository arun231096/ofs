package com.objectfrontier.training.java.base;
public class SomethingIsWrong {

        public static void main(String[] args) {

           // Rectangle myRect; this the wrong declaration
            Rectangle myRect = new Rectangle();
            myRect.width = 40;
            myRect.height = 50;
            System.out.println("myRect's area is " + myRect.area());
        }
}

class Rectangle {

    int width;
    int height;

    int area() {
    return (width * height);
    }
}
    