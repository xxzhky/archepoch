package com.gp.vip.ptn.decorator;

public class BattercakeWithEggAndSausage extends BattercakeWithEgg {

    @Override
    protected String GetMsg() {
        return super.GetMsg() +"+一根香肠";
    }

    @Override
    public int price() {
        return super.price()+3;
    }
}
