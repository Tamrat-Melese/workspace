package com.mpp.lab2.prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNum;
    private List<OrderLine> orderLineList;

    public Order(String orderNum){
        this.orderNum = orderNum;
        orderLineList = new ArrayList<>();
    }

    public Order(String orderNum, List<OrderLine> orderLines){
        this.orderNum = orderNum;
        this.orderLineList = orderLines;
    }

    public void addOrderLine(OrderLine orderLine){
        orderLineList.add(orderLine);
    }
}
