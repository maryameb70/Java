package com.example.practicetwo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("com.example.practicetwo.Employee");

        //Constructor array
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor cons : constructors) {
            System.out.println("Name of Constructor : " + cons);
            System.out.println("Count of constructor parameter : " + cons.getParameterCount());

            Parameter[] parameters = cons.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor's parameter : " + parameter);
            }
            System.out.println();
        }
        System.out.println();

        //Method Array
        Method[] methods = c.getDeclaredMethods();
        System.out.println("Length of method : " + methods.length);
        for (Method method : methods) {
            System.out.println("Method name: \t" + method);
            System.out.println("Method return type : \t" + method.getReturnType());
            System.out.println("Method parameter count: \t" + method.getParameterCount());
            System.out.println();
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method's Parameter : " + parameter);
            }
            System.out.println();
        }
        System.out.println();

        //Class
        Class[] classes = c.getDeclaredClasses();
        for(Class class1 : classes) {
            System.out.println("class: "+class1);
            System.out.println("Name of class: "+class1.getSimpleName());
        }
        System.out.println();

        //Annotation
        Annotation[] annotations = c.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation: " + annotation);
        }
    }
}
