package com.study.extend;

public class SuperClass extends Exception{

    private String msg;

    private Exception e = new Exception();

    public SuperClass(){
        super("");

    }

    public SuperClass(String msg){
        this.msg = msg;
    }

//    public SuperClass(String msg,Exception e){
//        this.msg = msg;
//        this.e = e;
//    }
}
