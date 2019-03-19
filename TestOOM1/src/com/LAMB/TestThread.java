package com.LAMB;

/**
 * Created by Loinbo
 * DATE:2019/3/19
 * TIME:21:14
 */

public class TestThread {

    public void dontstop(){
        while(true){

        }

    }

    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontstop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        TestThread test = new TestThread();
        test.stackLeakByThread();
    }
}
