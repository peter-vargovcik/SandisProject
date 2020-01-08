package com.vargovcik.peter.happypear.dto;

public class ShopDetail {
    private int shopsInMinus ,shopsInPlus;
    private String shopName;
    private double shopsInMinusLosses ,shopsInPlusEarnings;

    public int getShopsInMinus() {
        return shopsInMinus;
    }

    public void setShopsInMinus(int shopsInMinus) {
        this.shopsInMinus = shopsInMinus;
    }

    public int getShopsInPlus() {
        return shopsInPlus;
    }

    public void setShopsInPlus(int shopsInPlus) {
        this.shopsInPlus = shopsInPlus;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public double getShopsInMinusLosses() {
        return shopsInMinusLosses;
    }

    public void setShopsInMinusLosses(double shopsInMinusLosses) {
        this.shopsInMinusLosses = shopsInMinusLosses;
    }

    public double getShopsInPlusEarnings() {
        return shopsInPlusEarnings;
    }

    public void setShopsInPlusEarnings(double shopsInPlusEarnings) {
        this.shopsInPlusEarnings = shopsInPlusEarnings;
    }
}
