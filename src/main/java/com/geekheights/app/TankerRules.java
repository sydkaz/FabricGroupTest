package com.geekheights.app;

class Slab {
    int minLimit;
    int maxLimit;

    int price;

    Slab next;

    public Slab(int minLimit, int maxLimit, int price, Slab next) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.price = price;
        this.next = next;
    }
}
public class TankerRules {
    Slab slabs;
    TankerRules(){
        slabs = new Slab(0,500,2,new Slab(501,1500,3,new Slab(1501,3000,5, new Slab(3001,Integer.MAX_VALUE,8, null))));
    }

    public static double calculatePrice(double guestWaterUsage){

        return 0;
    }
}
