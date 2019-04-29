package com.gp.vip.interview.test.classloaded;

public class ChildClass extends FatherClass {

    int i=3;
    int j=0;

    {
        System.out.println("C0");
    }

    public ChildClass(){
        System.out.println("C1");
    }
    static {
        System.out.println("C2");
    }
    {
        System.out.println("C3");
    }

    @Override
    public void out() {
        System.out.println(i+" "+j);
    }

    public static void main(String[] args) {
        FatherClass  c= new ChildClass();
        c.out();
        System.out.println(c.i+"--"+c.j);
    }
}
