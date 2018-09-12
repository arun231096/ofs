package com.ofs.training;

import java.lang.reflect.Modifier;

public class Myjavap {

    public static void main(String[] args)throws ClassNotFoundException  {

            Myjavap javap = new Myjavap();
            javap.runJavap(args[0]);
        }
    private void runJavap(String arg)throws ClassNotFoundException {

            Class<?> classname = Class.forName(arg);
            //print Class details
            out("Compiled from \"%s.java\"", classname.getSimpleName());
            //display interface
            displayClassHeader(classname);

            //display fields
//            displayFields(classname);

            //display methods
//            displayMethods(classname);

            //display Constructors
//            displayConstructors(classname);

            //display inner classes
//            displayInnerClasess(classname);


            System.out.println("}");
    }
    private void displayInnerClasess(Class<?> classname) {

            Class<?>[] declaredClasess = classname.getDeclaredClasses();
            for (Class<?> declaredclass : declaredClasess) {
                System.out.println(declaredclass);
            }
    }
    private void displayClassHeader (Class<?> classname) {

        StringBuilder classHeader = new StringBuilder();
        //append the modifier name of the class to the classheader
        classHeader.append(parseModifier(classname.getModifiers()));
        //append the class name to the class header
        classHeader.append(classname.getSimpleName());
        //append the interfaces to the class header
        classHeader.append(interfacesAndSuperClasess(classname));

        out("%s",classHeader.toString());
    }
    private String interfacesAndSuperClasess(Class<?> classname) {

        StringBuilder interfacesAndClass = new StringBuilder();
        Class[] interfaces = classname.getInterfaces();
        if (interfaces.length > 0) { interfacesAndClass.append(" implements");}
        for (Class inter_face : interfaces) {

        }
        return null;

    }
    private String parseModifier(int modifer) {

        return (Modifier.toString(modifer));
    }

//    private void displayFields(Class<?> classname) {
//          Field[] fields = classname.getDeclaredFields();
//          for(Field field : fields) {
//              System.out.print(Modifier.toString(field.getModifiers()));
//              System.out.print(" "+field.getGenericType());
//              System.out.print(" "+field.getName());
//              System.out.println(" "+field. getType());
//          }
//    }
//    private void displayConstructors (Class<?> classname) {
//
//          Constructor[] constructors = classname.getConstructors();
//          for(Constructor<?> constructor : constructors) {
//              int modifiers = constructor.getModifiers();
//              System.out.print(""+Modifier.toString(modifiers));
//              System.out.print(" "+constructor.getName()+" (");
//              Type[] types = constructor.getGenericParameterTypes();
//              for (Type type : types) {
//                  System.out.print(type.getTypeName()+" ");
//              }
//              System.out.println(")");
//          }
//    }
//    private void displayMethods(Class<?> classname) {
//
//        Method[] methods = classname.getDeclaredMethods();
//        for(Method method : methods) {
//            int modifiers = method.getModifiers();
//            System.out.print(""+Modifier.toString(modifiers));
//            Type returntype = method.getGenericReturnType();
//            System.out.print(" "+returntype.getTypeName());
//            System.out.print(" "+method.getName()+"(");
//            Type[] types = method.getGenericParameterTypes();
//            for (Type type : types) {
//                System.out.print(type.getTypeName()+" ");
//            }
//         System.out.println(")");
//      }
//    }
    private void out(String format, String values) {

        System.out.format(format, values);
        System.out.println();
    }
}




//Field[] fields = classname.getDeclaredFields();
//for(Field field : fields) {
//    System.out.println(field);
//}
//Constructor[] constructors = classname.getConstructors();
//for(Constructor constructor : constructors) {
//    //System.out.println(method);
//    int modifiers = constructor.getModifiers();
//    System.out.print(""+Modifier.toString(modifiers));
//    System.out.print(" "+constructor.getName()+"(");
//    Type[] types = constructor.getGenericParameterTypes();
//    for (Type type : types) {
//        System.out.print(type.getTypeName()+" ");
//    }
//    System.out.println(")");
//}
//Method[] methods = classname.getDeclaredMethods();
//for(Method method : methods) {
//    int modifiers = method.getModifiers();
//    System.out.print(""+Modifier.toString(modifiers));
//    Type returntype = method.getGenericReturnType();
//    System.out.print(" "+returntype.getTypeName());
//    System.out.print(" "+method.getName()+"(");
//    Type[] types = method.getGenericParameterTypes();
//    for (Type type : types) {
//        System.out.print(type.getTypeName()+" ");
//    }
//    System.out.println(")");
//}
