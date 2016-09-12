package com.mpp.lab2;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User {

    private List<Project> projects;

    public Manager(int id, String name) {
        super(id, name);
        projects = new ArrayList<>();
    }

    public void assignFeatureToDeveloper(Feature f, Developer d){
        d.assignFeature(f);
    }

    public void addProject(Project p){
        projects.add(p);
    }

    public void addFeatureToRelease(Feature f, Release r){
        r.addFeature(f);
    }

    public int reportCompletedWork(Sprint s){
        int completedWork = 0;
        for(Feature f : s.getFeatures()){
            completedWork += f.getAmountOfCompletedWork();
        }
        return completedWork;
    }

    public int reportWorkRemaining(Sprint s){
        int remainingWork = 0;
        for(Feature f : s.getFeatures()){
            remainingWork += f.getRemainingWork();
        }
        return remainingWork;
    }
}
