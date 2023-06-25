package com.example.algoritm.binarysearch;

public class Iterative {
    public static Integer binarySearch(Integer[] elements, int low, int high, int item) {
        int mid ;
        while (low <= high) {
            mid = (low + high) / 2;
            if (elements[mid] == item) {
                return mid+1;
            }
            if (elements[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] values = {90, 10, 3, 27, 4, 44, 49, 3,56};
        int item = 56;
        Integer[] sortedValues=SortArray.sort(values);
        Integer result = binarySearch(sortedValues, 0, sortedValues.length-1, item);
        System.out.print("The elements of the array are: ");
        for (int i = 0; i < sortedValues.length; i++) {
            System.out.print(sortedValues[i]+" ");
        }
        System.out.println();
        System.out.println("Element to be searched is: " + item);
        if (result == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element is present at " + result + " position of arr");
    }
}
