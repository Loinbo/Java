package com.lamb.Thread;

/**线程具有继承性
 * Created by Loinbo
 * DATE:2019/3/16
 * TIME:14:35
 */

class MyThread2 implements Runnable{
    @Override
    public void run(){
        System.out.println("线程A的优先级为："+Thread.currentThread().getPriority());
        Thread threadA = new Thread(new MyThread3());//实例化线程B对象
        threadA.start();
    }
}

class MyThread3 implements Runnable{
    @Override
    public void run(){
        System.out.println("线程B的优先级为："+Thread.currentThread().getPriority());
    }
}

public class ImplThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread2());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }
}
