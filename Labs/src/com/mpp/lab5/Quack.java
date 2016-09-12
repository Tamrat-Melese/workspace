package com.mpp.lab5;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("\tquacking");
    }
}
