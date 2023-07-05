package com.example.practiceone;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the class:");
        String className = scanner.nextLine();
        Class classObject = Class.forName(className);

        System.out.print("Enter the name of the method:");
        String methodName = scanner.nextLine();
        Method method = classObject.getDeclaredMethod(methodName);
        Object obj = classObject.newInstance();
        method.setAccessible(true);
        method.invoke(obj);

        Annotation[] annotations = classObject.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Names of class annotations: " + annotation.annotationType().getSimpleName());
        }

        System.out.print("Enter the field name:");
        String fieldName = scanner.nextLine();
        try {
            Field field = classObject.getDeclaredField(fieldName);
            field.set(obj,10);
            System.out.println(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
