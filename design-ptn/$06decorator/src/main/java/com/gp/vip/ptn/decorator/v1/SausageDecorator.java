package com.gp.vip.ptn.decorator.v1;

public class SausageDecorator extends BatterCakeDecorator{
    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void addPepper() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+2;
    }
}
