package com.mpp.lab4;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
    private double commission;
    private double baseSalary;
    private List<Order> orderList;

    public Commissioned(double commission, double baseSalary) {
        this.commission = commission;
        this.baseSalary = baseSalary;
        orderList = new ArrayList<>();
    }

    @Override
    public double calcGrossPay(int month, int year) {

        double totalOrderAmount = 0.0;

        YearMonth yearMonth = YearMonth.of(year, month);

        for(Order o : orderList){
            if(o.getOrderDate().equals(yearMonth.minusMonths(1)))
                totalOrderAmount += o.getOrderAmount();
        }

        return baseSalary + totalOrderAmount * commission;
    }

    public void addOrder(Order o){
        orderList.add(o);
    }
}
