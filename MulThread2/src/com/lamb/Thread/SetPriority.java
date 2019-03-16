package com.lamb.Thread;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;

/**设置优先级,获取主线程的优先级
 * Created by Loinbo
 * DATE:2019/3/16
 * TIME:13:11
 */

class MyThread1 implements Runnable{

    @Override
    public void run(){
        Thread t = Thread.currentThread();//创建一个当前线程的实例化对象
        System.out.println("当前线程"+t.getName()+"的优先级是："+t.getPriority());
    }
}

public class SetPriority {

    public static void main(String[] args) {

        /*获取主线程Thread-A的优先级*/
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()
                    + " 优先级是：" + Thread.currentThread().getPriority());

        }, "主线程Thread-A");
        threadA.start();

        /*将线程优先级设置为6*/
        //threadA.setPriority(6);将线程优先级设置为6
        //threadA.start();

        /*设置子线程的优先级*/

        MyThread1 mt = new MyThread1();
        Thread t1 = new Thread(mt,"子线程A");
        Thread t2 = new Thread(mt,"子线程B");
        Thread t3 = new Thread(mt,"子线程C");
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(NORM_PRIORITY);
        t3.setPriority(MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }

}
