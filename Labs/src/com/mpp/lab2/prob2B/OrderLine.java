package com.mpp.lab2.prob2B;

public class OrderLine {
    private Order order;

    public OrderLine(){
        order = new Order("");
    }

    public OrderLine(Order order){
        this.order = order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
