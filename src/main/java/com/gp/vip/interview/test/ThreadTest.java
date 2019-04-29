package com.gp.vip.interview.test;

public class ThreadTest {


    public static void main(String[] args) {
        Thread  t= new Thread(()->{
              System.out.println("00");
          });
        //t.getPriority();
        t.run();
        t.start();
        System.out.println("111");
    }
}
