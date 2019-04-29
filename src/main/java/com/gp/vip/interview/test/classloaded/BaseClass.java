package com.gp.vip.interview.test.classloaded;

public abstract class BaseClass {
    public BaseClass(){
        System.out.println("B1");
    }
    static {
        System.out.println("B2");
    }
    public abstract void out();
}
