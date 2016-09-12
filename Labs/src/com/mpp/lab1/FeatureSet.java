package com.mpp.lab1;

import java.util.ArrayList;
import java.util.List;

public class FeatureSet {
    private List<Feature> features;

    public FeatureSet(){
        features = new ArrayList<>();
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
