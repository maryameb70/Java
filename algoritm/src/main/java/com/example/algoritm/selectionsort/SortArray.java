package com.example.algoritm.selectionsort;

import java.util.Arrays;

public class SortArray {
    private int a;

    public static Integer[] sort(Integer[] array) {
        Integer[] sortedArray = new Integer[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int smallest_index = findSmallest(array);
            sortedArray[index++] = array[smallest_index];
            array[smallest_index] = null;
        }
        return sortedArray;
    }

    public static Integer findSmallest(Integer[] array) {
        Integer smallest = Integer.MAX_VALUE;
        int smallest_index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i] < smallest) {
                smallest = array[i];
                smallest_index = i;
            }
        }
        return smallest_index;
    }
}

class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(SortArray.sort(array)));
    }
}

