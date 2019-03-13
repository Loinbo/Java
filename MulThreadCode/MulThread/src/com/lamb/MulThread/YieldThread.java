package com.lamb.MulThread;

/**yield下的线程休眠：休眠时间不定，同一优先级获取CPU执行机会
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:16:32
 */

class MyThread4 implements Runnable{

    @Override
    public void run(){

        for(int i = 0 ;i<5; i++){

            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"循环执行第"+ ++i +"次");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class YieldThread {

    public static void main(String[] args) {

        MyThread4 mt1 = new MyThread4();
        MyThread4 mt2 = new MyThread4();
        MyThread4 mt3 = new MyThread4();

        new Thread(mt1,"子线程A").start();
        new Thread(mt2,"子线程B").start();
        new Thread(mt3,"子线程C").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
