package com.example.algoritm.recursive;

public class MaximumNumberInList {
    private static int recursiveMax(Integer[] arr, int length) {
        if (length == 1)
            return arr[0];
        return Math.max(recursiveMax(arr, length - 1), arr[length - 1]);
    }

    public static void main(String[] args) {
        Integer[] array = {3, 23, 10, 40};
        System.out.println("Maximum number in a list:" + MaximumNumberInList.recursiveMax(array, array.length));
    }
}
