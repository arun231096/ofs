package com.objectfrontier.training.java.base;
/*
* Problem 1:- we cannot access the normal variable in to static block because memory for the static class has been initilized when the class is loaded.
  class Problem is the normal public class in that class String  s class is declared so, If I want use the String s, I need a object so without object
  I cannot use the String s class into my program. If the String s class is static.It can be use by the static class Inner.

* Problem 2 :- Even though the String as static and class as a static we cannot execute the program because there is no main method. we can execute
  the program without main but we need to use static block. So in this case we need to declare a main method to execute the program.

  Program in nas

  public class Problem {
    static String s;
    static class Inner {
        void testMethod() {
            s = "Set from Inner";
        }
    }
}
 */

 /* Modified solution 1 :-
    In this case inside the static class method is an non static method so we cannot use the method without creating a an object. so I declared the testMethod
    as a static method (static void testMethod()).
 */

public class Problem {

    static String s;
    static class Inner {

        static void testMethod() {
            s = "Set from Inner";
        }
    }

    public static void main(String[] args) {
        Inner.testMethod();
    }
}

/* Modified solution 2 :-
    In this case I am creating the object for inner class from that object we can use the string
*/

/*public class Problem {

    static String s;

    static class Inner {

        static void testMethod() {
            s = "Set from Inner";
        }
    }

    public static void main(String[] args) {

        Inner in =  new Inner();
        in.testMethod();
    }
}
*/
