package com.mpp.lab1;

import java.util.ArrayList;
import java.util.List;

public class Release extends FeatureSet{
    private String name;
    private List<Sprint> sprints;

    public Release(String name){
        this.name = name;
        sprints = new ArrayList<>();
    }

}
