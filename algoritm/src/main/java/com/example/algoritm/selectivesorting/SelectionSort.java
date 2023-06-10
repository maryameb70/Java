package com.example.algoritm.selectivesorting;

import java.util.Arrays;

public class SelectionSort {
    private int a;
    public static Integer[] sort(Integer[] array) {
        Integer[] newArray = new Integer[array.length];
        int index=0;
        for (int i = 0; i < array.length; i++) {
            int smallest = findSmallest(array);
            newArray[index++] = array[smallest];
            array[smallest] = null;
        }
        return newArray;
    }


    public static Integer findSmallest(Integer[] array) {
        Integer smallest = Integer.MAX_VALUE;
        int smallest_index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=null && array[i] < smallest) {
                smallest = array[i];
                smallest_index = i;
            }
        }
        return smallest_index;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        System.out.println(s.getClass());
        System.out.println(s.hashCode());
        String ss="mari";
        System.out.println(ss.equals("m"));
        Integer[] array=new Integer[]{5,3,6,2,10};
        System.out.println(Arrays.toString(SelectionSort.sort(array)));
    }
}

