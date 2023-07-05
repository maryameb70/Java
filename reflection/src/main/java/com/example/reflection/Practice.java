package com.example.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of class:");
        String className = scanner.nextLine();
        Class classObject = Class.forName(className);

        System.out.print("Enter name of method:");
        String methodName = scanner.nextLine();
        Method method = classObject.getDeclaredMethod(methodName);
        Object obj = classObject.newInstance();

        Annotation[] annotations = classObject.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Names of class annotations: " + annotation.annotationType().getSimpleName());
        }
        method.setAccessible(true);
        method.invoke(obj);
    }
}
