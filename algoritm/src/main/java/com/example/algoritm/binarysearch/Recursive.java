package com.example.algoritm.binarysearch;

public class Recursive {
    public static int binarySearch(int[] elements, int beg, int end, int value) {
        int mid;
        if (end >= beg) {
            mid = (beg + end) / 2;
            if (elements[mid] == value) {
                return mid + 1;
            } else if (elements[mid] < value) {
                return binarySearch(elements, mid + 1, end, value);
            } else {
                return binarySearch(elements, beg, mid - 1, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int values[] = {8, 10, 22, 27, 37, 44, 49, 55, 69}; // given array
        int item = 37; // value to be searched
        int result = binarySearch(values, 0, values.length-1, item); // Store result
        System.out.print("The elements of the array are: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        System.out.println("Element to be searched is: " + item);
        if (result == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element is present at " + result + " position of arr");
    }
}

