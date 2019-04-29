package com.gp.vip.interview.test.classloaded;

public class FatherClass extends BaseClass {

    int i=0;
    int j=3;
    {
        System.out.println("F0");
    }
    public FatherClass(){
        System.out.println("F1");
    }
    static {
        System.out.println("F2");
    }
    {
        System.out.println("F3");
    }
    @Override
    public void out() {
        System.out.println(i+" "+j);
    }
}
