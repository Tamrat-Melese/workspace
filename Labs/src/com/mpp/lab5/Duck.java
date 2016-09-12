package com.mpp.lab5;

public abstract class Duck implements FlyBehavior, QuackBehavior{

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    @Override
    public void quack() {
        quackBehavior.quack();
    }

    @Override
    public void fly() {
        flyBehavior.fly();
    }

    public void swim(){
        System.out.println("\tswimming");
    }

    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
