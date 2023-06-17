package com.example.algoritm.quicksort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void sort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex =(( highIndex - lowIndex) + lowIndex)/2;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        sort(array, lowIndex, leftPointer - 1);
        sort(array, leftPointer + 1, highIndex);

    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}

class Main {
    public static void main(String[] args) {
        Random random = new Random();
       // int[] numbers = new int[10];
        int[] numbers = {1, 12, 5, 26, 7, 14, 3, 7, 2};
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = random.nextInt(100);
//        }

        QuickSort.sort(numbers );
        System.out.println(Arrays.toString(numbers));
    }
}