package com.mpp.lab1;

import java.util.ArrayList;
import java.util.List;

public class Developer extends User {
    private List<Feature> features;

    public Developer(int id, String name) {
        super(id, name);
        features = new ArrayList<>();
    }
}
