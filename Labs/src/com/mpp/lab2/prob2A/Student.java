package com.mpp.lab2.prob2A;

public class Student {
    private String name;
    private GradeReport gradeReport;

    public Student(String name){
        this.name = name;
        gradeReport = new GradeReport();
    }

    public Student(String name, GradeReport gradeReport){
        this.name = name;
        this.gradeReport = gradeReport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGradeReport(GradeReport gradeReport) {
        this.gradeReport = gradeReport;
    }
}
