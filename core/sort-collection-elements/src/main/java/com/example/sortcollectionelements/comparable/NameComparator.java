package com.example.sortcollectionelements.comparable;

import java.util.Comparator;

public class NameComparator implements Comparator<StudentComparable> {
    public int compare(StudentComparable s1, StudentComparable s2){
        return s1.name.compareTo(s2.name);
    }
}
