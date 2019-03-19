package com.LAMB;

import java.util.ArrayList;
import java.util.List;

/**Java堆溢出：-Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * Created by Loinbo
 * DATE:2019/3/19
 * TIME:20:07
 */

public class TestOOM {

    static class OOMobject{

    }

    public static void main(String[] args) {

        List<OOMobject> list = new ArrayList<>();

        while(true) {

            list.add(new OOMobject());//不断创建对象，使得对象数量达到最大堆容量
        }

    }
}
