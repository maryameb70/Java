package com.example.algoritm.recursive;

public class Factorial {
    private static int recursiveFact(int number) {
        if (number == 1) {
            return 1;
        }
        return number * recursiveFact(number - 1);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " is: " + recursiveFact(num));
    }
}
