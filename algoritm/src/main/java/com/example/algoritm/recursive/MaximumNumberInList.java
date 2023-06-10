package com.example.algoritm.recursive;

public class MaximumNumberInList {
    private static int MaxRecursive(Integer[] arr, int length) {
        if (length == 1)
            return arr[0];
        return Math.max(MaxRecursive(arr, length - 1), arr[length - 1]);
    }

    public static void main(String[] args) {
        Integer[] array = {3, 23, 10, 40};
        System.out.println("Maximum number in a list:" + MaxRecursive(array, array.length));
    }
}
