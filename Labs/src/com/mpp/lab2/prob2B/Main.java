package com.mpp.lab2.prob2B;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("0000001");
        OrderLine orderLine = new OrderLine(order);

        order.addOrderLine(orderLine);
    }
}
