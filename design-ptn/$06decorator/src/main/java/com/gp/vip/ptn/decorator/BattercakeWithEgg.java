package com.gp.vip.ptn.decorator;

public class BattercakeWithEgg extends Battercake{
    @Override
    protected String GetMsg() {
        return super.GetMsg() +"+1个鸡蛋";
    }

    @Override
    public int price() {
        return super.price()+1;
    }
}
