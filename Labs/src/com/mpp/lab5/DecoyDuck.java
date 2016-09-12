package com.mpp.lab5;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new CannotFly());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("\tdisplaying decoy duck");
    }
}
