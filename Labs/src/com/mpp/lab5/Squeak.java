package com.mpp.lab5;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("\tsqueaking");
    }
}
