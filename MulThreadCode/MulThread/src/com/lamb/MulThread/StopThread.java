package com.lamb.MulThread;

/**设置标记或调用不安全的stop()方法使线程退出
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:17:10
 */

class MyThread6 implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while (flag) {
            try {
                Thread.sleep(2000);
                System.out.println("第" + i + "次执行，线程名称:" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread6 mt1 = new MyThread6();
        Thread thread = new Thread(mt1,"子线程A");
        thread.start();
        Thread.sleep(1000);
        mt1.setFlag(false);
        //thread.stop();
        System.out.println("线程结束");
    }
}
