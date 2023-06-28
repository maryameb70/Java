package com.example.sortcollectionelements.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgeComparator implements Comparator<StudentComparable> {
    @Override
    public int compare(StudentComparable s1, StudentComparable s2) {
        if (s1.age == s2.age)
            return 0;
        else if (s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}

class TestComparator {
    public static void main(String[] args) {
        //Creating a list of students
        ArrayList<StudentComparable> al = new ArrayList<>();
        al.add(new StudentComparable(101, "Vijay", 23));
        al.add(new StudentComparable(106, "Ajay", 27));
        al.add(new StudentComparable(105, "Jai", 21));

        System.out.println("Sorting by Name");
//Using NameComparator to sort the elements
        Collections.sort(al, new NameComparator());
//Traversing the elements of list
        for (StudentComparable st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        System.out.println("sorting by Age");
//Using AgeComparator to sort the elements
        Collections.sort(al, new AgeComparator());
//Travering the list again
        for (StudentComparable st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

    }
}

