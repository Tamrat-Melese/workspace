package com.mpp.lab2;

import java.util.ArrayList;
import java.util.List;

public class Release{
    private String name;
    private List<Feature> features;
    private List<Sprint> sprints;

    public Release(String name){
        this.name = name;
        sprints = new ArrayList<>();
        features = new ArrayList<>();
    }

    public void addFeature(Feature f){
        features.add(f);
    }

    public void addSprint(Sprint s){
        sprints.add(s);
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }
}
