package com.mpp.lab1;

import java.util.ArrayList;
import java.util.List;

public class Project extends FeatureSet {
    private String name;
    private List<Release> releases;

    public Project(String name){
        this.name = name;
        releases = new ArrayList<>();
    }

}
