package com.vargovcik.peter.happypear.dto;

public class Shop {
    private String name;
    private double val1,val2;

    public Shop(String name, double val1, double val2) {
        this.name = name;
        this.val1 = val1;
        this.val2 = val2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVal1() {
        return val1;
    }

    public void setVal1(double val1) {
        this.val1 = val1;
    }

    public double getVal2() {
        return val2;
    }

    public void setVal2(double val2) {
        this.val2 = val2;
    }
}
