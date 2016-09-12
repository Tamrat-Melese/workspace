package com.mpp.lab4;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Hourly emp1 = new Hourly(7.5, 40);
        Salaried emp2 = new Salaried(32000);
        Commissioned emp3 = new Commissioned(0.1, 10000);
        emp3.addOrder(new Order(1, new Date(2016,9,3), 1000));
        emp3.addOrder(new Order(2, new Date(2016,9,5), 5000));
        emp3.addOrder(new Order(3, new Date(2016,8,3), 2000));

        Employee[] empList = new Employee[]{emp1, emp2, emp3};

        for(Employee e : empList){
            PayCheck p = e.calcCompensation(9, 2016);
            p.print();
        }
    }
}
