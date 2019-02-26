package com.objectfrontier.training.java.base;
public class FindAbsolutePath  {

    public static void main (String args[]){

        FindAbsolutePath absPath= new FindAbsolutePath();
        Class cc = absPath.getClass();
        String path = cc.getProtectionDomain().getCodeSource().getLocation().getPath();
         System.out.println ("Absolute Path : "+path);
    }
}