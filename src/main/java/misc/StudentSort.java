package main.java.misc;

import java.util.Arrays;
import java.util.Comparator;


public class StudentSort {


    public static class SortByCgpa implements Comparator<Student> {

        @Override
        public int compare(Student stu1, Student stu2) {
            return (int) ((int) stu2.cgpa - stu1.cgpa);
        }

    }


    public static void main(String[] args) {

        Student[] arr = { new Student("Mana", 8.2),
                new Student("Adi", 10.0),
                new Student("Raju", 5.2) };


        for(Student s: arr) {
            System.out.println(s.getName());
        }

        Arrays.sort(arr, new SortByCgpa());

        System.out.println("After sort");
        for(Student s: arr) {
            System.out.println(s.getName());
        }

    }
}
