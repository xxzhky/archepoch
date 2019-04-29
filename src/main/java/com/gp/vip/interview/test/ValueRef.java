package com.gp.vip.interview.test;

public class ValueRef {

    {
        System.out.println(999);
    }

    public static void change (String str){
        str="00000000";
    }

    public static void changeObj (Object  obj){
        obj=new Obj("999999999");
    }

    public static void main(String[] args) {
        String str="hello";
        change(str);
        System.out.println(str);
        Obj obj= new Obj(str);
        changeObj(obj);
        System.out.println(obj.str);

    }
}
class Obj {
    String str;
    public Obj(String str){
        this.str=str;
    }
}