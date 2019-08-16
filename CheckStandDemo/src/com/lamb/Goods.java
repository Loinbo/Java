package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/8/15
 * TIME:22:34
 * 商品信息
 */

public class Goods {

    private String id;  //商品编号
    private String name;  //商品名称
    private double price;  //商品价格


    public Goods(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getId() {
        return this.id;
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

    @Override
    public String toString() {
        return String.format("[%2s] %s %.2f",this.getId(),this.getName(),this.getPrice());
    }
}
