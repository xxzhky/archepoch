package com.gp.vip.ptn.decorator.v1;

import org.junit.Test;

import static org.junit.Assert.*;

public class BatterCakeTest {

    @Test
    public void getMsg() {
        BatterCake b;

        //路边 买一个煎饼
        b= new BaseBatterCake();

        //加一个鸡蛋
        b= new EggDecorator(b);

        //加一根香肠
        b= new SausageDecorator(b);

        //再加一个鸡蛋
        b=new EggDecorator(b);

        System.out.println(b.getMsg()+" ,共计花费："+b.getPrice());


    }
}