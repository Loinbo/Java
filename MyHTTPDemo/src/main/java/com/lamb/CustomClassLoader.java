package com.lamb;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Loinbo
 * DATE:2019/8/30
 * TIME:10:44
 */

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String filename = "D:\\\\LAMB\\Code\\MyHTTPDemoController\\webapp\\" + name +".class";
        byte[] buf = new byte[8192];
        int len;
        try {
            len = new FileInputStream(filename).read(buf);
        } catch (IOException e) {
            throw new ClassNotFoundException("没找到", e);
        }

        return defineClass(name, buf, 0, len);
    }
}