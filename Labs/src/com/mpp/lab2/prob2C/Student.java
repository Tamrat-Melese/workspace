package com.mpp.lab2.prob2C;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    private List<Section> sections;

    public Student(String name){
        this.name = name;
        sections = new ArrayList<>();
    }

    public void addSection(Section section){
        sections.add(section);
    }
}
