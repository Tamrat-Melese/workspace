package com.mpp.lab5;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("\tcannot quack");
    }
}
