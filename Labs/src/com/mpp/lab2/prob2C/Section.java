package com.mpp.lab2.prob2C;

import java.util.ArrayList;
import java.util.List;

public class Section {
    public String sectionNum;
    private List<Student> students;

    public Section(String sectionNum){
        this.sectionNum = sectionNum;
        students = new ArrayList<>();
    }

    public Section(String secNum, Student s){

    }
    public void addStudent(Student student){
        students.add(student);
    }
}
