package com.lamb.MulThread;

/**处理线程休眠操作
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:16:10
 */

class MyThread3 implements Runnable{
    private boolean flag = true;

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run(){
        int i = 0;
        while(this.flag){
            System.out.println("线程"+Thread.currentThread().getName()+"当前执行次数i："+ ++i +"次");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class SleepThread {

    public static void main(String[] args) {

        MyThread3 mt1 = new MyThread3();
        MyThread3 mt2 = new MyThread3();
        MyThread3 mt3 = new MyThread3();

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
