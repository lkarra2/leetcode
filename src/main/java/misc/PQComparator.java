package main.java.misc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQComparator {

    public static void main(String[] args) {

        PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudentComparator());

        Student student1 = new Student("Nandini", 3.2);

        // Adding a student object containing fields
        // name and cgpa to priority queue
        pq.add(student1);
        Student student2 = new Student("Anmol", 3.6);
        pq.add(student2);
        Student student3 = new Student("Palak", 4.0);
        pq.add(student3);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }

    }

}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student stu1, Student stu2) {
        if(stu1.cgpa < stu2.cgpa)
            return 1;
        else if(stu1.cgpa > stu2.cgpa)
            return -1;
        return 0;
    }
}

class Student {
    public String name;
    public double cgpa;

    public Student(String n, double c) {
        this.name = n;
        this.cgpa = c;
    }

    public String getName() {
        return name;
    }
}
