package com.mpp.lab5;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("\tcannot fly");
    }
}
