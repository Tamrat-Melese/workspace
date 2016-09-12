package com.mpp.lab2.prob2C;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("StudentName");
        Section section = new Section("111111");

        student.addSection(section);
        section.addStudent(student);
    }
}
