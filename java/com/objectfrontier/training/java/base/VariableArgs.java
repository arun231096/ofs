package com.objectfrontier.training.java.base;
public class VariableArgs {

    public static void main(String[] args) {

        VariableArgs arguments =  new VariableArgs();
        arguments.parseArgs("hello world");
        arguments.parseArgs("hello world", "I", "am", "arun", "kumar");
        arguments.parseArgs(10, 20, 30, 40, 50, 60);
        
    }
    
    void parseArgs(String args) {
    System.out.println (args);
    }
    
    void parseArgs(String... args) {

    String toprint="";
    for(String argument : args) {
        toprint = toprint + argument + " ";
    }
    System.out.println(toprint);
    }

    void parseArgs(int... args) {

    int toprint = 0;
    for(int argument : args) {
        toprint = toprint + argument;
    }
    System.out.println(toprint);
    }
}
