package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Crea un comparador para ordenar una lista de objetos de tipo Students.
 * por el campo marks
 */
public class MyClass {
    /**
     * main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create the ArrayList object
        List<Students> s = new ArrayList<>();
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
            if (s1.marks == s2.marks) {

                return 0;
            } else if (s1.marks > s2.marks) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
