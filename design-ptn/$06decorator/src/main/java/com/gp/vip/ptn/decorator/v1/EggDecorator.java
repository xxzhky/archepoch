package com.gp.vip.ptn.decorator.v1;

public class EggDecorator extends BatterCakeDecorator{
    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void addPepper() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
