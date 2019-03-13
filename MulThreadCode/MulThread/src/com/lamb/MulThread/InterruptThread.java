package com.lamb.MulThread;

/**线程中断Thread.Interrupt
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:17:33
 */

class MyThread7 implements Runnable{

    private boolean flag = true;

    @Override
    public void run(){
        int i = 1;
        while(flag){
            try {
                Thread.sleep(1000);

                boolean bool = Thread.currentThread().isInterrupted();//判断当前线程中断情况
                if(bool){
                    System.out.println("线程处于非阻塞状态"+bool);//非阻塞状态
                    break;
                }
                System.out.println("第"+i+"次执行，线程名称:"+Thread.currentThread().getName());
                /*阻塞状态，线程被调用了interrupt()方法，清除中断标志后抛出异常java.lang.InterruptedException*/
                i++;
            } catch (InterruptedException e) {

                e.printStackTrace();
                System.out.println("退出阻塞");//退出阻塞状态，且中断标志被系统自动清除，并将bool重新设置为false
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println("阻塞中断：" + bool);
                return;//退出run()方法，中断进程
            }
        }
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}


public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread7 mt1 = new MyThread7();
        Thread thread = new Thread(mt1,"子线程A");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println("线程结束");
    }
}
