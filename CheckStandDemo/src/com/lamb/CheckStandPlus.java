package com.lamb;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2019/8/15
 * TIME:22:34
 */

public class CheckStandPlus {
    private static Scanner sc = new Scanner(System.in);

    //商品中心管理
    private static GoodsCenter goodsCenter = new SimpleGoodsCenter();

    //订单中心管理
    private static OrderCenter orderCenter = new SimpleOrderCenter(goodsCenter);

    private static Integer orderId = 0;

    //首页
    public static void helpInfo() {
        System.out.println("*************** 欢迎使简易收银台 *****************");
        System.out.println("       [U] 使用 [S] 设置 [P] 保存 [A] 关于 [Q] 退出");
        System.out.println("       输入:  U S P A Q 进入操作                    ");
        System.out.println("*************************************************");
    }

    //退出
    public static void quit() {
        System.out.println("*************************************************");
        System.out.println("                欢迎使用，下次再见                 ");
        System.out.println("*************************************************");
        System.exit(0);
    }

    //关于
    public static void about() {
        System.out.println("******************** 关于 ***********************");
        System.out.println("        名称：简易收银台                          ");
        System.out.println("        功能：基于字符界面的收银台操作系统          ");
        System.out.println("        作者: Loinbo                        ");
        System.out.println("        版本: v1.0.0                          ");
        System.out.println("        意见反馈：Loinbo@163.com            ");
        System.out.println("*************************************************");
    }

    //买单
    public static void usageInfo() {
        System.out.println("******************* 买单功能 ********************");
        System.out.println("    [A] 添加商品 [D] 取消商品 [L] 浏览商品        ");
        System.out.println("    [S] 查看订单 [R] 返回上级        ");
        System.out.println("       输入:  A D L S R 进入操作                  ");
        System.out.println("*************************************************");
    }

    //设置
    public static void settingInfo() {
        System.out.println("******************* 设置功能 ********************");
        System.out.println("    [A] 商品上架 [D] 商品下架 [U] 商品修改        ");
        System.out.println("    [S] 查看商品 [L] 浏览订单 [R] 返回上级        ");
        System.out.println("       输入:  A D U S L R 进入操作                ");
        System.out.println("*************************************************");
    }

    public static void usage(){
        //1.创建订单，并且添加到订单管理中心
        Order order = new Order(String.valueOf(++ orderId));
        orderCenter.addOrder(order);
        usageInfo();
        System.out.println(orderCenter.orderTable(order.getOrderId()));

        while(true){
            String line = sc.nextLine();
            switch (line.trim()){
                case "S":
                    System.out.println(orderCenter.orderTable(order.getOrderId()));
                    break;
                case "A":{
                    System.out.println("请输入下单信息 [编号 数量] (如下格式:1 2) ：");
                    String value = sc.nextLine();
                    String[] infoArray = value.split(" ");
                    if(infoArray.length == 2){
                        Goods goods = goodsCenter.getGoods(infoArray[0]); //根据输入取出商品编号
                        if(goods != null){
                            order.add(infoArray[0], Integer.parseInt(infoArray[1]));

                            System.out.println(orderCenter.orderTable(order.getOrderId()));;
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息!");
                    break;
                }
                case "D":{
                    System.out.println("请输入取消信息[编号 数量] (如下格式:1 2) ：");
                    String value = sc.nextLine();
                    String[] infoArray = value.split(" ");
                    if(infoArray.length == 2){
                        Goods goods = goodsCenter.getGoods(infoArray[0]);
                        if(goods != null){
                            order.cancel(infoArray[0], Integer.parseInt(infoArray[1]));;
                            System.out.println(orderCenter.orderTable(order.getOrderId()));;
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息!");
                    break;
                }
                case "L":{
                    System.out.println(goodsCenter.listGoods());
                }
                case "R":{
                    return;
                }
                default:{
                    usageInfo();
                }
            }
        }
    }

    public static void setting(){
        settingInfo();
        while(true){
            String line = sc.nextLine();
            switch (line.trim()){
                case "A":{
                    System.out.println("请输入要上架商品信息(如下格式：1 矿泉水 2) ：");
                    Goods goods = readGoods();
                    if(goods == null){
                        System.out.println("请按照格式要求输入信息!");
                        break;
                    }
                    if(goodsCenter.isExistGoods(goods.getId())){
                        System.out.println("该商品已经存在，请勿重复添加！");
                    } else {
                        goodsCenter.addGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "D":{
                    System.out.println("请输入要下架商品信息编号(如下格式：1) :");
                    Goods goods = readGoods();
                    if(goods == null){
                        System.out.println("请按照格式要求输入信息!");
                        break;
                    }
                    if(goodsCenter.isExistGoods(goods.getId())){
                        goodsCenter.removeGoods(goods.getId());
                    } else {
                        System.out.println("请输入存在的商品信息");
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "U": {
                    System.out.println("请输入要修改的商品信息(如下格式：1 矿泉水 3) ：");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("请按照格式要求输入信息!");
                        break;
                    }
                    if (goodsCenter.isExistGoods(goods.getId())) {
                        goodsCenter.updateGood(goods);
                    } else {
                        System.out.println("请输入存在的商品");
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "S":{
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "L":{
                    System.out.println(orderCenter.ordersTable());
                    break;
                }
                case "R":{
                    return;
                }
                default:
                    settingInfo();
            }
        }
    }

    private static Goods readGoods() {
        String value = sc.nextLine();
        String[] infoArray = value.split(" ");
        if(infoArray.length == 3 || infoArray.length == 1){
            if(infoArray.length == 3){
                Goods goods = new Goods(infoArray[0], infoArray[1], Double.parseDouble(infoArray[2]));
                return goods;
            }
            Goods goods = new Goods(infoArray[0], "", 0.0D);
            return goods;
        }
        return null;
    }

    public static void main(String[] args) {
        helpInfo();
        //初始化加载文件信息
        goodsCenter.load();
        orderCenter.loadOrders();
        while(true){
            String line = sc.nextLine();
            switch (line.trim()){
                case "U":
                    usage();
                    helpInfo();
                    break;
                case "S":
                    setting();
                    helpInfo();
                    break;
                case "A":
                    about();
                    break;
                case "P":
                    goodsCenter.store();  //商品信息保存
                    orderCenter.storeOrders();  //订单信息保存
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    helpInfo();
            }
        }
    }
}
