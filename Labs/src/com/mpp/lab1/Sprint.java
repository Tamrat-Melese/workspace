package com.mpp.lab1;

import java.util.Date;

public class Sprint extends FeatureSet {
    private String name;
    private Date dueDate;

    public Sprint(String name){
        this.name = name;
        dueDate = new Date();
    }
}
