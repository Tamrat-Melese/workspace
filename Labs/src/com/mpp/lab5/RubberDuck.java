package com.mpp.lab5;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new CannotFly());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("\tdisplaying rubber duck");
    }
}
