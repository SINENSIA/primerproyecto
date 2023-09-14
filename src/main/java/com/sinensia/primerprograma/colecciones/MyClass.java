package com.sinensia.primerprograma.colecciones;

// Java program to Sort ArrayList using Comparator

import java.util.*;

// creates the comparator for comparing marks value

public class MyClass {
    public static void main(String[] args) {
        // create the ArrayList object
        ArrayList<Students> s = new ArrayList<Students>();
        s.add(new Students(1, "Rahul", 80));
        s.add(new Students(2, "Anand", 95));
        s.add(new Students(3, "Rohan", 70));
        s.add(new Students(4, "Ragav", 35));
        s.add(new Students(5, "Sweta", 55));

        System.out.println("before sorting");
        for (Students student : s) {
            System.out.println(student.roll + " " + student.name
                    + " " + student.marks);
        }
        System.out.println();

        System.out.println(
                "After sorting in Ascending order(sorted by marks)");

        // call the sort function
        Collections.sort(s, new MarksComparator());
        for (Students student : s) {
            System.out.println(student.roll + " " + student.name
                    + " " + student.marks);
        }
    }

    // create the Students class
    static class Students {
        int roll;
        String name;
        int marks;

        // constructor
        Students(int roll, String name, int marks) {
            this.roll = roll;
            this.name = name;
            this.marks = marks;
        }
    }

    static class MarksComparator implements Comparator<Students> {

        // override the compare() method
        public int compare(Students s1, Students s2) {
            if (s1.marks == s2.marks)
                return 0;
            else if (s1.marks > s2.marks)
                return 1;
            else
                return -1;
        }
    }
}
