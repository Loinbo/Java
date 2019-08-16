package com.lamb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Loinbo
 * DATE:2019/8/15
 * TIME:22:35
 */

public class Order {

    private final String orderId;

    private final Map<String, Integer> goodsInfo = new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 订单添加商品
     * @param goodsId  商品id
     * @param count  商品数量
     */
    public void add(String goodsId, Integer count){
        Integer sum = this.goodsInfo.get(goodsId);
        if(sum == null){
            sum = count;
        } else {
            sum += count;
        }
        this.goodsInfo.put(goodsId, sum);
    }

    /**
     * 取消订单信息
     * @param goodsId
     * @param count
     */
    public void cancel(String goodsId, Integer count){
        Integer sum = this.goodsInfo.get(goodsId);
        if(sum != null){
            sum -= count;
            sum = sum < 0 ? 0 : sum;
            if(sum > 0){
                this.goodsInfo.put(goodsId, sum);
            } else {
                this.goodsInfo.remove(goodsId);
            }
        }
    }


    public void clear(){
        this.goodsInfo.clear();
    }

    public String getOrderId() {
        return orderId;
    }

    /**
     * 获取订单信息
     * @return
     */
    public Map<String,Integer> getOrderInfo(){
        return this.goodsInfo;
    }
}
