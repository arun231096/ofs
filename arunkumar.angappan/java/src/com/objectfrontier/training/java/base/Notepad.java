package com.objectfrontier.training.java.base;

class Notepad {

    public static void main(String[] args) throws Exception {

    Notepad toopen = new Notepad();
    Runtime rs = Runtime.getRuntime();
    String filename = toopen.getClass().getCanonicalName();
    filename = "Notepad++ "+filename+".java";
    rs.exec(filename);
    }    
}
