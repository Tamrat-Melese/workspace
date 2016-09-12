package com.mpp.lab2;

public class Feature {
    private String name;
    private Developer dev;
    private int estimateEffort;
    private int remainingWork;

    public Feature(String name){
        this.name = name;
    }

    public void setDev(Developer dev) {
        this.dev = dev;
    }

    public void setEstimateEffort(int estimateEffort) {
        this.estimateEffort = estimateEffort;
    }

    public void setRemainingWork(int remainingWork) {
        this.remainingWork = remainingWork;
    }

    public int getRemainingWork() {
        return remainingWork;
    }

    public int getAmountOfCompletedWork(){
        return estimateEffort - remainingWork;
    }
}
