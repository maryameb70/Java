package com.example.algoritm.recursive;

public class CountItemsInList {
    public static Integer count(int length) {
        if (length == 1) {
            return 1;
        } else {
            return count(length - 1) + 1;
        }
    }

    public static Integer count(int[] array, int length) {
        if (length == 0) {
            return 0;
        } else {
            return count(array, length - 1) + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 33, 3, 2, 6, 7, 4, 5, 6};
        System.out.println("Count the number of items in a list:" + CountItemsInList.count(array.length));
        System.out.println("Count the number of items in a list:"+CountItemsInList.count(array, array.length));
    }
}


