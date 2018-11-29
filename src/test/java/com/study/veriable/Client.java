package com.study.veriable;

import java.util.Map;

public class Client {

    public static void main(String[] args) {
        String resultString = new String();
        String trim = resultString.trim();
        Veriable veriable = new Veriable();
        Map<String, Class> map = veriable.query();
        map.values().forEach(
            clas -> {
                System.out.println(clas.getName());
            });
    }
}
