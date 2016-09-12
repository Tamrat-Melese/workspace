package com.mpp.lab4;

public class PayCheck {
    private double grossPay;
    private double fica;
    private double state;
    private double local;
    private double medicare;
    private double socialSecurity;

    public PayCheck(double grossPay) {
        this.grossPay = grossPay;
        this.fica = grossPay * 0.23;
        this.state = grossPay * 0.05;
        this.local = grossPay * 0.01;
        this.medicare = grossPay * 0.03;
        this.socialSecurity = grossPay * 0.075;
    }

    public void print(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[GrossPay: ").append(grossPay).append("; ")
                .append("FICA: ").append(fica).append("; ")
                .append("state: ").append(state).append("; ")
                .append("local: ").append(local).append("; ")
                .append("medicare: ").append(medicare).append("; ")
                .append("social security:" ).append(socialSecurity)
                .append("NetPay: ").append(getNetPay()).append("]");

        return sb.toString();
    }

    public double getNetPay(){
        return grossPay - (fica + state + local + medicare + socialSecurity);
    }
}
