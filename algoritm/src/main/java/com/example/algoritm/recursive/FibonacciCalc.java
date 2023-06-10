package com.example.algoritm.recursive;

public class FibonacciCalc {
    public static int fibRecursion(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1 || number == 2)
            return 1;
        return fibRecursion(number - 1) + fibRecursion(number - 2);
    }

    public static void main(String[] args) {
        int num = 9;
        System.out.println("Fibonacci Calc of " + num + " is: " + fibRecursion(num));
        System.out.print("Fibonacci Series of " + num + " is: \n");
        for (int i = 0; i < num; i++) {
            System.out.print(fibRecursion(i) + " ");
        }
    }
}
