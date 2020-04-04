package com.entity;

import com.epam.shop.entity.Entity;

import java.util.Date;

public class Order extends Entity {
    private int customerId;
    private Date orderDate;
    private boolean deliveryType;

    public Order(int customerId, Date orderDate,boolean deliveryType){
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.deliveryType = deliveryType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(boolean deliveryType) {
        this.deliveryType = deliveryType;
    }
}
