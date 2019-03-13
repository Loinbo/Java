package com.lamb.MulThread;


/**利用Runnable接口实现多线程
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:13:13
 */


class MyThread implements Runnable{

    private String line;
    public MyThread(String line){
        this.line = line;
    }

    @Override
    public void run(){
        for(int i = 0; i<10 ;i++){
            System.out.println(this.line+",i="+i);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyThread myThread1= new MyThread("Thread1");
        MyThread myThread2= new MyThread("Thread2");
        MyThread myThread3= new MyThread("Thread3");

        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();
    }
}
