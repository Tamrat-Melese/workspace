package com.mpp.lab4;

public abstract class Employee {
    private long empId;

    public void print(){

    }

    public PayCheck calcCompensation(int month, int year){
        double grossSalary = calcGrossPay(month, year);
        return new PayCheck(grossSalary);
    }

    public abstract double calcGrossPay(int month, int year);

}
