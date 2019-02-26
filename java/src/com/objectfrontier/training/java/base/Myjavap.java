package com.objectfrontier.training.java.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

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
            displayFields(classname);

            //display Constructors
            displayConstructors(classname);

            //display methods
            displayMethods(classname);

            //display inner classes
//            displayInnerClasess(classname);


            out("}", "");
    }

    private void displayClassHeader (Class<?> classname) {

        StringBuilder classHeader = new StringBuilder();
        //append the modifier name of the class to the classheader
        classHeader.append(parseModifier(classname.getModifiers()));
        //append the class name to the class header
        classHeader.append(" "+classname.getSimpleName());
        //append the interfaces to the class header
        classHeader.append(interfacesAndSuperClasess(classname));
        //display the class header
        out("%s {",classHeader.toString());
    }

    private String interfacesAndSuperClasess(Class<?> classname) {

        StringBuilder interfacesAndClass = new StringBuilder();
        Class[] interfaces = classname.getInterfaces();
        if (interfaces.length > 0) { interfacesAndClass.append(" implements");}
        for (Class inter_face : interfaces) {
            interfacesAndClass.append(" "+inter_face.getName()+",");
        }
        interfacesAndClass.replace(interfacesAndClass.length() -1, interfacesAndClass.length(), "");
        Class superClass= classname.getSuperclass();
        if(superClass != null) {

            interfacesAndClass.append(" extends");
            interfacesAndClass.append(" "+superClass.getName());
        }
        return interfacesAndClass.toString();

    }

    private void displayFields(Class<?> classname) {
          Field[] fields = classname.getFields();
          StringBuilder stringFields = new StringBuilder();
          for(Field field : fields) {
              stringFields.append(parseModifier(field.getModifiers()));
              stringFields.append(" " + field.getType());
              stringFields.append(" " + field.getName() + ";\n");
          }
          out(" %s", stringFields.toString());
    }
    private void displayConstructors (Class<?> classname) {

        StringBuilder stringConstructor = new StringBuilder();
          Constructor[] constructors = classname.getDeclaredConstructors();
          for(Constructor<?> constructor : constructors) {
              stringConstructor.append(parseModifier(constructor.getModifiers()));
              stringConstructor.append(" " +constructor.getName() + "(");
              Type[] types = constructor.getParameterTypes();
              if (types.length > 0) {
                  stringConstructor.append(findType(types));
                  stringConstructor.replace(stringConstructor.length() -2, stringConstructor.length(), "");
              }
              stringConstructor.append(");\n ");
          }
          out(" %s",stringConstructor.toString());
    }

    private void displayMethods(Class<?> classname) {

        StringBuilder stringMethod = new StringBuilder();
        Method[] methods = classname.getDeclaredMethods();
        for(Method method : methods) {
            stringMethod.append(" " + parseModifier(method.getModifiers()));
            stringMethod.append(" "+method.getReturnType());
            stringMethod.append(" " +method.getName() + "(");
            Type[] types = method.getParameterTypes();
            if (types.length > 0) {
                stringMethod.append(findType(types));
                stringMethod.replace(stringMethod.length() -2, stringMethod.length(), "");
            }
            stringMethod.append(")");
            Class[] exceptiontypes = method.getExceptionTypes();
            StringBuilder exceptions = new StringBuilder();
            for (Class exceptiontype : exceptiontypes) {
                exceptions.append(" "+ exceptiontype.getSimpleName());
            }
            if (exceptiontypes.length > 0) {
                exceptions.replace(exceptions.length() - 2, exceptions.length(), "");
                stringMethod.append(" " + exceptions + ";\n");
            } else { stringMethod.append(";\n");}

        }
        out("%s", stringMethod.toString());
    }

    private String parseModifier(int modifer) {

        return (Modifier.toString(modifer));
    }

    private StringBuilder findType(Type[] types) {

        StringBuilder stringType = new StringBuilder();
        for (Type type : types){
            stringType.append(type.getTypeName()+ ", ");
          }
        return stringType;

    }

    private void out(String format, String values) {

        System.out.format(format, values);
        System.out.println();
    }
}
