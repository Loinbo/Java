package com.lamb.Thread;

/**
 * Created by Loinbo
 * DATE:2019/3/16
 * TIME:13:54
 */

public class TestThread {

    public static void code1() {
        //主线程的优先级：
        System.out.println("主线程的优先级：" + Thread.currentThread().getPriority());

        //在主线程中创建一个线程，并且不指定优先级
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " 优先级是：" + Thread.currentThread().getPriority());

        }, "Thread-A");
        //threadA.setPriority(6);
        threadA.start();
    }

    public static void main(String[] args) {

        Runnable runnable = new PriorityRunnable();
        Thread threadA = new Thread(runnable, "Thread-A");
        threadA.setPriority(Thread.MAX_PRIORITY);

        Thread threadB = new Thread(runnable, "Thread-B");
        threadB.setPriority(Thread.NORM_PRIORITY);

        Thread threadC = new Thread(runnable, "Thread-C");
        threadC.setPriority(Thread.MIN_PRIORITY);

        threadA.start();
        threadB.start();
        threadC.start();

    }
}

class PriorityRunnable implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " 优先级是：" + t.getPriority());
    }
}