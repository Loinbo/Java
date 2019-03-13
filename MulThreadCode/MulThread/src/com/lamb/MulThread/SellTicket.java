package com.lamb.MulThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**多线程习题：通过使用Runnable接口或Callable接口实现卖票窗口
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:13:48
 */

/*
class MyThread1 implements Runnable{
    private int tickets = 10;

    public void setTickets(int tickets){
        this.tickets = tickets;
    }

    @Override
    public void run(){
        while(tickets>0){
            System.out.println(Thread.currentThread().getName()+"剩余票数："+tickets--);
        }
    }
}
*/

class MyThread2 implements Callable<String> {

    private int tickets = 10;

    public void setTickets(int tickets){
        this.tickets = tickets;
    }

    @Override
    public String call() throws Exception {
        while(this.tickets>0){
            System.out.println(Thread.currentThread().getName()+"剩余票数："+this.tickets--);
        }
        return "票卖完啦！欢迎下次光临";
    }
}

public class SellTicket {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        MyThread1 myThread1 = new MyThread1();
        MyThread1 myThread2 = new MyThread1();
        MyThread1 myThread3 = new MyThread1();
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();
        */


        MyThread2 myThread1 = new MyThread2();
        MyThread2 myThread2 = new MyThread2();
        MyThread2 myThread3 = new MyThread2();

        FutureTask<String> task1 = new FutureTask<>(new MyThread2());
        FutureTask<String> task2 = new FutureTask<>(new MyThread2());
        FutureTask<String> task3 = new FutureTask<>(new MyThread2());
        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();

        System.out.println(task1.get());

    }
}
