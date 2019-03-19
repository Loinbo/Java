package com.LAMB;

/**循环引用问题--JVM参数 :-XX:+PrintGC
 * Created by Loinbo
 * DATE:2019/3/19
 * TIME:21:14
 */

public class TestGC {
    public Object instance = null;
    private static final int _2MB = 1024 * 1024*2;
    private byte[] data = new byte[_2MB];

    public static void  testGC() {
        TestGC test1 = new TestGC();
        TestGC test2 = new TestGC();

        test1.instance = test2;
        test2.instance = test1;

        test1 = null;
        test2 = null;
        System.gc();//执行垃圾回收
    }
        public static void main(String[] args){
            testGC();
        }
}
