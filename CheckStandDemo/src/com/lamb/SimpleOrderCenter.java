package com.lamb;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Loinbo
 * DATE:2019/8/15
 * TIME:22:34
 */

public class SimpleOrderCenter implements OrderCenter{

    private Map<String,Order> orderMap = new HashMap<>();

    private GoodsCenter goodsCenter;

    public SimpleOrderCenter(GoodsCenter goodsCenter){
        this.goodsCenter = goodsCenter;
    }

    @Override
    public void addOrder(Order order) {
        this.orderMap.put(order.getOrderId(), order);
    }

    @Override
    public void removeOrder(Order order) {
        this.orderMap.remove(order.getOrderId(), order);
    }

    @Override
    public String ordersTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================");
        sb.append("\n");
        sb.append("订单编号   总价");
        sb.append("\n");
        for(Order order : this.orderMap.values()){

            Map<String, Integer> goodsMap = order.getOrderInfo();
            double totalPrice = 0.0;

            for(Map.Entry<String, Integer> entry : goodsMap.entrySet()){  //用entrySet返回Set集合:<String orderId, count>

                String goodsId = entry.getKey();
                Integer goodsCount = entry.getValue();
                Goods goods = goodsCenter.getGoods(goodsId);
                totalPrice += goods.getPrice() * goodsCount;

            }
            sb.append(String.format("%2s\\t\\t%.2f",order.getOrderId(),totalPrice));
            sb.append("\n");
        }

        sb.append("=================================");
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String orderTable(String orderId) {

        StringBuilder sb = new StringBuilder();
        Order order = this.orderMap.get(orderId);
        sb.append("=================================");
        sb.append("\n");
        sb.append("编号: " + order.getOrderId());
        sb.append("\n");
        sb.append("打印时间：" + LocalDate.now().toString());
        sb.append("\n");
        sb.append("=================================");
        sb.append("\n");
        sb.append("编号       名称      数量      单价");
        sb.append("\n");
        double total = 0.0D;
        for(Map.Entry<String, Integer> entry : order.getOrderInfo().entrySet()){
            Goods goods = this.goodsCenter.getGoods(entry.getKey());
            sb.append(String.format("%2s\t%s\t%d\t%.2f", entry.getKey(), goods.getName(), entry.getValue(), goods.getPrice()));

            total += goods.getPrice() *entry.getValue();
            sb.append("\n");
        }
        sb.append("=================================");
        sb.append("\n");
        sb.append(String.format("总价: %.2f", total));
        sb.append("\n");
        sb.append("=================================");
        sb.append("\n");

        return sb.toString();
    }

    @Override
    public void storeOrders() {
        System.out.println("保存所有订单到文件每个订单记录：编号和总价");
    }

    @Override
    public void loadOrders() {
        System.out.println("加载文件中的数据。实例化Order");
    }
}
