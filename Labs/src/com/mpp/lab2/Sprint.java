package com.mpp.lab2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprint{
    private String name;
    private List<Feature> features;
    private Date dueDate;

    public Sprint(String name, Date dueDate){
        this.name = name;
        this.dueDate = dueDate;
        features = new ArrayList<>();
    }

    public void addFeature(Feature f){
        features.add(f);
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
