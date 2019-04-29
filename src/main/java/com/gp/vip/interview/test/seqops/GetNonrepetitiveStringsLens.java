package com.gp.vip.interview.test.seqops;

public class GetNonrepetitiveStringsLens {

    public static int getNonRepetitiveLens(String a){
        //Integer.parseInt("");
        //abfggjjjjjkiuytrew

        outer:
        for (int i=0; i<a.length()-1; i++){

            for (int j = i+1; j< a.length(); j++){
                switch (a.charAt(i) ^ a.charAt(j)) {

                    case(0):
                        System.out.println("00000");
                        break outer;
                    default:
                        System.out.println(a.charAt(i) ^ a.charAt(j));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //getNonRepetitiveLens("aabf");

        int  c,k=0;
        for (int i = 0; i < 4; i++) {

            c=++k;
            System.out.println("=="+c);
            System.out.println(i);
        }
        System.out.println("---------------");
        for (int i = 0; i < 4; ++i) {

            System.out.println(i);
        }
    }
}
