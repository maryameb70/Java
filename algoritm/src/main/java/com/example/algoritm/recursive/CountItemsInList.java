package com.example.algoritm.recursive;

public class CountItemsInList {
    public static Integer recursiveCount(int length) {
        if (length == 1) {
            return 1;
        } else {
            return recursiveCount(length - 1) + 1;
        }
    }

    public static Integer recursiveCount(int[] array, int length) {
        if (length == 0) {
            return 0;
        } else {
            return recursiveCount(array, length - 1) + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 33, 3, 2, 6, 7, 4, 5, 6};
        System.out.println("Count the number of items in a list:" + recursiveCount(array.length));
        System.out.println("Count the number of items in a list:" + recursiveCount(array, array.length));
    }
}


