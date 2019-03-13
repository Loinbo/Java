package com.lamb.MulThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**join在线程中的使用方法--等待该线程停止
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:16:46
 */


class MyThread5 implements Runnable{
    @Override
    public void run(){
        try {
            System.out.println("主线程睡眠前的时间：");
            JoinThread.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠结束的时间:");
            JoinThread.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


public class JoinThread {

    public static void main(String[] args) throws InterruptedException {
        MyThread5 mt1 = new MyThread5();
        Thread thread = new Thread(mt1,"子线程A");
        thread.start();
        System.out.println(Thread.currentThread().getName());
        thread.join();
        System.out.println("代码结束");
    }

    public static void printTime(){
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String time = format.format(date);
        System.out.println(time);
    }
}
