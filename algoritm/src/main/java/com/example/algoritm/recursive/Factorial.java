package com.example.algoritm.recursive;

public class Factorial {
    private static int factRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * factRecursive(number - 1);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " is: " + factRecursive(num));
    }
}
