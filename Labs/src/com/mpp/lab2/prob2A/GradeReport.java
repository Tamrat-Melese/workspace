package com.mpp.lab2.prob2A;

public class GradeReport {
    private Student student;

    public GradeReport(){
        student = new Student("");
    }

    public GradeReport(Student student){
        this.student = student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
