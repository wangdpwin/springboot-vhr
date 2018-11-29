package com.study.veriable.impl;

import com.study.veriable.Handler;

public class CommonHandler implements Handler {

    @Override
    public void handle() {
        System.out.println("common handler");
    }
}
