package com.mpp.lab5;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("\tdisplaying red head duck");
    }
}
