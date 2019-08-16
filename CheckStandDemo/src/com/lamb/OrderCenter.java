package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/8/15
 * TIME:22:35
 */

public interface OrderCenter {

    //添加订单
    void addOrder(Order order);


    //移除订单
    void removeOrder(Order order);

    //所有订单信息
    String ordersTable();

    //根据订单编号获取信息
    String orderTable(String orderId);

    //存储订单信息
    void storeOrders();

    //加载订单信息
    void loadOrders();

}
