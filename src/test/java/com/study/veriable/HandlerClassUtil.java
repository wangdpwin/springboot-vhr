package com.study.veriable;

public class HandlerClassUtil {

    public static Class getHandler() {
        Class c = null;
        try {
            c = Class.forName("com.study.veriable.impl.TypeHandler");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }
}
