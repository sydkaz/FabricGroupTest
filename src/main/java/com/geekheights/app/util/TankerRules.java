package com.geekheights.app.util;


public class TankerRules {
    static Slab slabs;
    static {
        slabs = new Slab(0, 500, 2, new Slab(501, 1500, 3, new Slab(1501, 3000, 5, new Slab(3001, Integer.MAX_VALUE, 8, null))));
    }
    public static double calculatePrice(double guestWaterUsage) {
        return slabs.calPrice(guestWaterUsage);
    }

   static class Slab {
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

        private double calPrice(double price) {
            if (price > 0) {
                double appliedOnAmount = price >= maxLimit ? maxLimit : price;
                double remainingAmount = price >= maxLimit ? price - maxLimit : 0;
                //System.out.println(appliedOnAmount +" "+remainingAmount);
                if (next != null) {
                    return (appliedOnAmount * this.price) + next.calPrice(remainingAmount);
                } else
                    return (appliedOnAmount * this.price);
            }
            return 0.0;
        }
    }
}
