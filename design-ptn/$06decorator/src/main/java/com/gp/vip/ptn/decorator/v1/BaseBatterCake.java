package com.gp.vip.ptn.decorator.v1;

public class BaseBatterCake extends BatterCake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
