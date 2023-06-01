package ir.mapsa.timecomplexity.main;

import ir.mapsa.timecomplexity.CalcTimeComplexity;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CalcTimeComplexity compare = new CalcTimeComplexity(new ArrayList<>());
        compare.create();
        System.out.println("The size of the array before adding is:" + compare.getCollection().size());
        System.out.println("-----------ArrayList-----------");
        System.out.println("Time complexity in Add is:" + compare.compareAddTime(compare.getCollection()));
        System.out.println("The size of the array after adding is:" + compare.getCollection().size());
        System.out.println("Time complexity in Contains is:" + compare.compareContainsTime(compare.getCollection()));
        System.out.println("Time complexity in Remove is:" + compare.compareRemoveTime(compare.getCollection()));
        System.out.println("-----------LinkedList-----------");
        compare = new CalcTimeComplexity(new LinkedList<>());
        compare.create();
        System.out.println("Time complexity in Add is:" + compare.compareAddTime(compare.getCollection()));
        System.out.println("Time complexity in Contains is:" + compare.compareContainsTime(compare.getCollection()));
        System.out.println("Time complexity in Remove is:" + compare.compareRemoveTime(compare.getCollection()));
        System.out.println("-----------HashSet-----------");
        compare = new CalcTimeComplexity(new HashSet<>());
        compare.create();
        System.out.println("Time complexity in Add is:" + compare.compareAddTime(compare.getCollection()));
        System.out.println("Time complexity in Contains is:" + compare.compareContainsTime(compare.getCollection()));
        System.out.println("Time complexity in Remove is:" + compare.compareRemoveTime(compare.getCollection()));
    }
}
