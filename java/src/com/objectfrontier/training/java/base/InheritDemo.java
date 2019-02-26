package com.objectfrontier.training.java.base;
public class InheritDemo {

    public static void main(String[] args) {

        Animal pet1 = new Dog();
        Animal pet2 = new Cat();
        Animal forest_animal = new Snake();
        pet1.move();
        pet2.move();
        forest_animal.move(); 
        /* Overridding */
        Dog micky = new Dog();
        micky.bark(); //Overloading
        micky.bark("neighbour");
        micky.print();
    }
}

class Animal {

    int eyes;

    Animal() {

        eyes = 2;
    }
    void move(){

        System.out.println("Animal is moving");
    }
}

class Dog extends Animal{

    int legs;

    Dog() {

        legs = 4;
    }

    void move() {

        System.out.println("Dog is moving with "+legs+" legs");
    }

    void bark() {

        System.out.println("Dog bark difference when see the owner");
    }

    void bark(String stranger) {

        System.out.println("Dog bark difference when see the "+stranger);
    }

    void print() {

        System.out.println("Eyes = "+eyes);
        System.out.println("Legs = "+legs);
    }
}

class Cat extends Animal{

    int legs;

    Cat() {

        legs = 4;
    }

    void move() {

        System.out.println("cat is moving with "+legs+" legs");
    }

    void run() {

        System.out.println("cat runs different when see the owner");
    }

    void run(String stranger) {

        System.out.println("cat runs different when see the "+stranger);
    }

    void print() {

        System.out.println("Eyes = "+eyes);
        System.out.println("Legs = "+legs);
    }
}

class Snake extends Animal {

    void move() {
        System.out.println("Snake moving with out legs");
    }

    void print() {
        System.out.println("Eyes = "+eyes);
    }
}
