package com.lamb.MulThread;

/**利用匿名内部类或Lambda表达式创建Runnable对象
 * Created by Loinbo
 * DATE:2019/3/13
 * TIME:13:13
 */

public class Thread1 {
    public static void main(String[] args) {
        //Runnable runnable = new Runnable();
        //Thread thread = new Thread(runnable,"子线程1");
        //thread.start();----->new Thread (thread).start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("HelloWorld");
            }
        }).start();


        Runnable runnable = () -> System.out.println("HelloWorld");
        new Thread(runnable).start();
    }
}
