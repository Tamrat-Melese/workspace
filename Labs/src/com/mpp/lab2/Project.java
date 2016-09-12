package com.mpp.lab2;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Feature> backlog;
    private List<Release> releases;
    private Manager manager;

    public Project(String name){
        this.name = name;
        releases = new ArrayList<>();
        backlog = new ArrayList<>();
    }

    public void addFeatureToBacklog(Feature f){
        backlog.add(f);
    }

    public void addRelease(Release r){
        releases.add(r);
    }

    public List<Feature> getBacklog() {
        return backlog;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
