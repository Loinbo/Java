package com.LAMB;

/**任何一个对象的
 finalize()方法都只会被系统自动调用一次，finalize()方法可以使得对象获得一次自救的机会，仅一次
 * Created by Loinbo
 * DATE:2019/3/19
 * TIME:21:31
 */

public class TestFinalize {

    public static TestFinalize test;

    public void isAlive() {
        System.out.println("对象自救");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行自救");
        test = this;
    }
    public static void main(String[] args)throws Exception {
        test = new TestFinalize();//test!= null
        test = null;
        System.gc();

        Thread.sleep(1000);
        if (test != null) {
            test.isAlive();
        }else {
            System.out.println("对象死亡");
        }

        //二次调用gc()不会逃离死亡
        test = null;
        System.gc();
        Thread.sleep(500);//阻塞，gc()为守护线程
        if (test != null) {
            test.isAlive();
        }else {
            System.out.println("对象死亡");
        }

    }
}
