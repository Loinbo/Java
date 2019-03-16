package com.lamb.Thread;

/**守护线程
 * Created by Loinbo
 * DATE:2019/3/16
 * TIME:14:54
 */

class DaemonRunnable implements Runnable{
    @Override
    public void run(){
        int i = 0;
        try {

            while(true) {
                System.out.println(Thread.currentThread().getName() + " 调用第 " + ++i + " 次");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 中断了");
        }
    }
}

public class DaemonThread {

    public static void main(String[] args) {

        /**测试主线程为何种线程类型**/
        System.out.println(Thread.currentThread().isDaemon());
        //输出：false,是用户线程

        Thread threadA = new Thread(new DaemonRunnable(),"子线程A");
        threadA.setDaemon(true);//垃圾回收线程，此方法调用要在启动线程之前
        threadA.start();

        Thread threadB = new Thread(new DaemonRunnable(),"子线程B");
        threadB.start();

        try {
            Thread.sleep(3000);
            threadB.interrupt();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
