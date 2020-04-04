package com.epam.shop.entity;

public class Stock extends Entity {
    private int count;

    public Stock(int count){
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
