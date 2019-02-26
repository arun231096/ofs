package com.objectfrontier.training.java.base;
abstract class Shape {

   abstract float area();
   abstract float perimeter();
}

class Circle extends Shape {

    float radius;

    Circle(float radius) {
        this.radius = radius;
    }

    @Override
    float area() {

        float area = 3.14f * radius * radius;
        return area;
    }

    @Override
    float perimeter() {

        float perimeter = 2 * 3.14f * radius;
        return perimeter;
    }
}

class Square extends Shape {

    float side;

    Square(float side) {
        this.side = side;
    }

    @Override
    float area() {

        float area = side * side;
        return area;
    }

    @Override
    float perimeter() {

        float perimeter = 4 * side;
        return perimeter;
    }
}

public class AbstractDemo {

    public static void main(String[] args) {

        Shape circle = new Circle(10.00f);
        Shape square = new Square(12.3f);
        float areaOfCircle = circle.area();
        float areaOfSquare = square.area();
        float periOfCircle = circle.perimeter();
        float periOfsquare = square.perimeter();
        System.out.println("Circle Area = "+areaOfCircle+" Perimeter = "+periOfCircle);
        System.out.println("Square Area = "+areaOfSquare+" Perimeter = "+periOfsquare);
    }
}
