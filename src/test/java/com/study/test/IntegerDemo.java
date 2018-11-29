package com.study.test;

import org.junit.Test;

public class IntegerDemo {

    @Test
    public void equalsTest(){
        Integer a1 = 129;
        Integer a2 = 129;
        System.out.println(a1.intValue() == a2);
    }

    @Test
    public void equalsNull(){
        Integer a1 = null;
        Integer a2 = 129;
        System.out.println(a1.intValue() == a2.intValue());
    }

}
