package com.example.algoritm;

import java.util.Arrays;

public class Algorithm {
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
