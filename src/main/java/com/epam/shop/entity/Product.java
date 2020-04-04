package com.epam.shop.entity;

public class Product extends Entity {

    private String name;
    private double price;
    private String description;
    private String stockIdNum;
    private int languageId;
    private int stockId;

    public Product(String name, double price, String description, String stockIdNum, int languageId, int stockId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockIdNum = stockIdNum;
        this.languageId = languageId;
        this.stockId = stockId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStockIdNum() {
        return stockIdNum;
    }

    public void setStockIdNum(String stockIdNum) {
        this.stockIdNum = stockIdNum;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }
}

