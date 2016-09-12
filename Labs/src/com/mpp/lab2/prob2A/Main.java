package com.mpp.lab2.prob2A;

public class Main {
    public static void main(String[] args) {
        GradeReport gradeReport = new GradeReport();
        Student student = new Student("Student A");

        student.setGradeReport(gradeReport);
        gradeReport.setStudent(student);
    }
}
