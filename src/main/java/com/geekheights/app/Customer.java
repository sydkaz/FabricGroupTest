package com.geekheights.app;

import com.geekheights.app.consts.AppConstants;
import com.geekheights.app.strategy.GuestBillingStrategy;
import com.geekheights.app.strategy.ResidentConsumptionStrategy;
import com.geekheights.app.util.TankerRules;
import com.geekheights.app.util.Utility;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private final List<Integer> guests = new ArrayList<>();
    private ResidentConsumptionStrategy strategy;

    Double corporationWater;
    Double borewellWater;

    public void add(Integer numberOfGuests) {
        this.guests.add(numberOfGuests);
    }



    // Payment of bill
    public void printBill() {
        int sum = this.guests.stream().mapToInt(v -> v).sum();
        System.out.println("Liter "+strategy.getActPrice(corporationWater, borewellWater));
        System.out.println("bill "+strategy.getActPrice(corporationWater, borewellWater)* AppConstants.PRICE_CORPORATION_WATER.getText());
        System.out.println("Liter "+ Utility.roundToNearestInetegr(strategy.getActPrice(borewellWater, corporationWater)));
        System.out.println("bill "+Utility.roundToNearestInetegr(strategy.getActPrice(borewellWater, corporationWater)* AppConstants.PRICE_BOREWELL_WATER.getText()));
        System.out.println("Liter "+ GuestBillingStrategy.getBillingStrategy().getActPrice(sum));
        System.out.println("bill "+ TankerRules.calculatePrice(GuestBillingStrategy.getBillingStrategy().getActPrice(sum)));
        System.out.println("Total due: " + sum);
        //this.drinks.clear();
    }

    // Set Strategy
    public void setStrategy(ResidentConsumptionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setRatio(Double corporationWater, Double borewellWater) {
        this.corporationWater = corporationWater;
        this.borewellWater = borewellWater;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "guests=" + guests +
                ", strategy=" + strategy +
                ", corporationWater=" + corporationWater +
                ", borewellWater=" + borewellWater +
                '}';
    }
}
