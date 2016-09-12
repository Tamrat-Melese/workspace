package com.mpp.lab4;

public class Hourly extends Employee {
    private double hourlywage;
    private double hourPerWeek;

    public Hourly(double hourlywage, double hourPerWeek) {
        this.hourlywage = hourlywage;
        this.hourPerWeek = hourPerWeek;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlywage * hourPerWeek * 4;
    }
}
