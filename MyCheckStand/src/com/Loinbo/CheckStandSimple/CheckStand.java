package com.Loinbo.CheckStandSimple;

import java.time.LocalDate;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * Created by Loinbo
 * DATE:2019/3/9
 * TIME:17:51
 */

public class CheckStand {

    private static Scanner scanner = new Scanner(System.in);

    //欢迎界面
    public static void welcoInfo() {
        System.out.println("**************欢迎使用简易超市收银台*************");
        System.out.println("       [U] 使用 [S] 设置 [A] 关于 [Q] 退出      ");
        System.out.println("           输入： U  S  A  Q  进入操作          ");
        System.out.println("**********************************************");
    }

    //退出界面
    public static void quit() {
        System.out.println("**********************************************");
        System.out.println("                谢谢使用，下次再见              ");
        System.out.println("**********************************************");
        System.exit(0);
    }

    //信息界面
    public static void about() {
        System.out.println("*********************关于*********************");
        System.out.println("               名称：简易超市收银台             ");
        System.out.println("         功能:基于字符界面的收银台操作系统       ");
        System.out.println("                   作者：Loinbo               ");
        System.out.println("                   版本：v1.0.0               ");
        System.out.println("            意见反馈：Loinbo@7k7k.com          ");
        System.out.println("**********************************************");
    }

    //买单界面
    public static void usageInfo() {
        System.out.println("*******************买单功能********************");
        System.out.println("  [S] 查看 [A] 下单 [D] 取消 [L] 浏览 [R] 返回  ");
        System.out.println("         输入： S  A  D  L  R  进入操作         ");
        System.out.println("**********************************************");
    }

    //设置界面
    public static void settingInfo() {
        System.out.println("*******************设置功能********************");
        System.out.println("  [S] 查看 [A] 上架 [D] 下架 [U] 修改 [R] 返回  ");
        System.out.println("         输入： S  A  D  U  R  进入操作         ");
        System.out.println("**********************************************");
    }

    //买单功能
    public static void usage() {
        usageInfo();
        GoodsCenter.printGoods();//打印商品
        Order order = new Order();
        while (true) {
            String message = scanner.nextLine();
            switch (message.trim().toUpperCase()) {
                case "S": {
                    order.printOrder();
                    break;
                }
                case "A": {
                    System.out.println("欢迎光临：请输入下单信息[编号 数量](如下格式：1  2)：");
                    String line = scanner.nextLine();
                    String[] infoArray = line.split(" ");
                    if (infoArray != null && (infoArray.length == 2)) {
                        Goods goods = GoodsCenter.getGoods(parseInt(infoArray[0]));//判断客户输入信息是否正确，正确则在商品中心调出商品信息
                        if (goods != null) {
                            order.add(goods, parseInt(infoArray[1]));
                            order.printOrder();
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息！");
                    break;
                }
                case "D": {
                    System.out.println("请输入取消[编号 数量](如下格式：1 2)：");
                    String line = scanner.nextLine();
                    String[] infoArray = line.split(" ");
                    if (infoArray != null && (infoArray.length == 2)) {
                        Goods goods = GoodsCenter.getGoods(parseInt(infoArray[0]));
                        if (goods != null) {
                            order.cancel(goods, parseInt(infoArray[1]));
                            order.printOrder();
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息！");
                    break;
                }
                case "L": {
                    GoodsCenter.printGoods();
                }
                case "R": {
                    return;
                }
                default: {
                    usageInfo();
                }
            }
        }

    }

    //设置功能
    public static void setting() {
        settingInfo();
        if (GoodsCenter.isFull()) {
            System.out.println("当前商品货架已经满了，如果需要进行添加请下降部分商品");
        }
        while (true) {
            String message = scanner.nextLine();
            switch (message.toUpperCase()) {
                case "S": {
                    GoodsCenter.printGoods();
                    break;
                }
                case "A": {
                    System.out.println("请输入上架商品信息(如下格式：1 矿泉水 2.0)：");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("请按照格式要求输入信息！");
                        break;
                    }
                    if (GoodsCenter.isFull()) {
                        System.out.println("当前商品货架已经满了，目前无法添加，请下架部分商品");
                    } else if (GoodsCenter.isExist(goods)) {
                        System.out.println("当前商品已经存在，请重新输入！");
                    } else {
                        GoodsCenter.addGoods(goods);
                        GoodsCenter.printGoods();
                    }
                    break;
                }
                case "D": {
                    System.out.println("请输入下架商品编号(如下格式：1)：");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("请按照格式要求输入信息！");
                        break;
                    }
                    if (GoodsCenter.isPutaway(goods)) {
                        GoodsCenter.soldOutGoods(goods);
                        GoodsCenter.printGoods();
                    } else {
                        System.out.println("请选择上架的商品编号，当前下架商品未设置");
                    }
                    break;
                }
                case "U": {
                    System.out.println("请输入修改商品的信息(如下格式：1 矿泉水 2.0)");
                    Goods goods = readGoods();
                    if (goods == null) {
                        System.out.println("请按照格式要求输入信息！");
                        break;
                    }
                    if (GoodsCenter.isPutaway(goods)) {
                        GoodsCenter.modifyGoods(goods);
                        GoodsCenter.printGoods();
                    } else {
                        System.out.println("请选择上架的商品编号，当前下架商品未设置");
                    }
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    settingInfo();
                }
            }
        }
    }

    //通过输入信息获取具体商品
    public static Goods readGoods() {
        String line = scanner.nextLine();
        String[] infoArray = line.split(" ");
        if (infoArray != null && (infoArray.length == 3 || infoArray.length == 1)) {
            if (infoArray.length == 3) {  //上架
                Goods goods = new Goods(parseInt(infoArray[0]), infoArray[1], Double.parseDouble(infoArray[2]));
                return goods;
            }  //Integer.parseInt(String):将String类型转换成Integer整型类型
            if (infoArray.length == 1) {  //下架
                Goods goods = new Goods(parseInt(infoArray[0]), "", 0.0D);
                return goods;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        welcoInfo();
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim().toUpperCase()) {
                case "U":
                    usage();
                    welcoInfo();
                    break;
                case "S":
                    setting();
                    welcoInfo();
                    break;
                case "A":
                    about();
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    welcoInfo();
            }
        }

    }
}
    //Order类
    class Order {
        private static int orderId = 0;
        private int id;
        private Goods[] items;
        private int[] itemsNumber;
        private int currentIndex;

        public Order() {
            this.id = ++orderId;
            this.items = new Goods[GoodsCenter.getMaxGoods()];
            this.itemsNumber = new int[GoodsCenter.getMaxGoods()];
            this.currentIndex = -1;
        }

        //添加订单
        public void add(Goods goods, int count) {
            int index = goods.getIndex();
            this.items[index] = goods;
            this.itemsNumber[index] += count;
        }

        //取消订单
        public void cancel(Goods goods, int count) {
            int index = goods.getIndex();
            int value = this.itemsNumber[index] - count;
            if (value > 0) {
                this.itemsNumber[index] = value;
            } else {
                this.items[index] = null;
                this.itemsNumber[index] = 0;
            }
        }

        public int getSize() {
            return this.currentIndex + 1;
        }

        //计算总价
        public double getTotalPrice() {
            double totalPrice = 0;
            for (int i = 0; i < this.items.length; i++) {
                Goods goods = this.items[i];
                if (goods != null) {
                    totalPrice += (this.itemsNumber[goods.getIndex()] * goods.getPrice());
                }
            }
            return totalPrice;
        }

        public int getId() {
            return this.id;
        }

        //打印订单
        public void printOrder() {
            System.out.println("===============================");
            System.out.println("编号: " + this.getId());
            System.out.println("打印时间: " + LocalDate.now().toString());
            System.out.println("===============================");
            System.out.println("编号 名称 数量  单价");
            for (int i = 0; i < this.items.length; i++) {
                Goods goods = this.items[i];
                if(goods != null){
                    int count = this.itemsNumber[goods.getIndex()];
                    if (count <= 0) {
                        continue;
                    }
                    System.out.println(String.format("%2d\t%2s\t%d\t%.2f", goods.getId(), goods.getName(), count, goods.getPrice()));
                }
            }
            System.out.println("===============================");
            System.out.println(String.format("总价: %.2f", this.getTotalPrice()));
            System.out.println("===============================");
        }
    }

        //Goods类
        class Goods {
            private int id;
            private String name;
            private double price;

            public Goods(int id, String name, double price) {
                this.id = id;
                this.name = name;
                this.price = price;
            }

            public int getId() {
                return this.id;
            }

            public int getIndex() {
                return this.getId() - 1;
            }

            public String getName() {
                return this.name;
            }

            public double getPrice() {
                return this.price;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            @Override
            public String toString() {
                //商品信息格式：1 矿泉水 2.0
                return String.format("[%2d] %s %.2f", this.getId(), this.getName(), this.getPrice());
            }
        }

        //货物中心
        class GoodsCenter {
            //1.新增  2.删除  3.修改  4.打印

            private static String placeholder = "--";//商品名占位符

            private static int maxGoods = 10;//商品数量最大值

            private static Goods[] goodsArray;//商品容器

            //初始化商品容器
            static {
                goodsArray = new Goods[maxGoods];
                for (int i = 0; i < goodsArray.length; i++) {
                    goodsArray[i] = new Goods(i + 1, "--", 0.0D);
                }
            }

            private GoodsCenter() {
                this.placeholder = placeholder;
                this.maxGoods = maxGoods;
                this.goodsArray = new Goods[maxGoods];
            }

            public static int getMaxGoods() {
                return maxGoods;
            }

            //添加商品
            public static void addGoods(Goods goods) {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (tmp.getId() == goods.getId()) {
                        tmp.setName(goods.getName());
                        tmp.setPrice(goods.getPrice());
                        break;
                    }
                }
            }

            //下架商品
            public static void soldOutGoods(Goods goods) {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (tmp.getId() == goods.getId()) {
                        tmp.setName(placeholder);
                        tmp.setPrice(0.0D);
                        break;
                    }
                }

            }

            //修改商品
            public static void modifyGoods(Goods goods) {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (tmp.getId() == goods.getId()) {
                        tmp.setName(goods.getName());
                        tmp.setPrice(goods.getPrice());
                        break;
                    }
                }
            }

            //判断商品是否存在
            public static boolean isExist(Goods goods) {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (tmp.getId() == goods.getId() && tmp.getName().equals(goods.getName())) {
                        return true;
                    }
                }
                return false;
            }

            //判断商品位是否存在
            public static boolean isPutaway(Goods goods) {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (tmp.getId() == goods.getId() && !tmp.getName().equals(placeholder)) {
                        return true;
                    }
                }
                return false;
            }

            //商品是否已满
            public static boolean isFull() {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (goodsArray[i].getName().equals(placeholder)) {
                        return false;
                    }
                }
                return true;
            }

            //商品未满则打印其信息
            public static Goods getGoods(int id) {
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    if (tmp.getId() == id && !tmp.getName().equals(placeholder)) {
                        return goodsArray[i];
                    }
                }
                return null;
            }


            //打印商品
            public static void printGoods() {
                System.out.println("******************  商品清单  ********************");
                System.out.println("\t" + "编号" + "\t" + "产品名称" + "\t\t" + "单价");
                for (int i = 0; i < goodsArray.length; i++) {
                    Goods tmp = goodsArray[i];
                    String name = tmp.getName();
                    if (name.equals(placeholder)) {
                        name = name + "[未上架]";
                    }
                    System.out.println("\t" + tmp.getId() + "\t" + name + "\t\t" + tmp.getPrice());
                }
                System.out.println("*************************************************");
            }
        }