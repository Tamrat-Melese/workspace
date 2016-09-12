package com.mpp.lab4;

public class Salaried extends Employee {
    private double salary;

    public Salaried(double salary) {
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }
}
