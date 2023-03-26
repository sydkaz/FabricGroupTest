package com.geekheights.app;

import com.geekheights.app.consts.AppConstants;
import com.geekheights.app.strategy.GuestBillingStrategy;
import com.geekheights.app.strategy.ResidentConsumptionStrategy;
import com.geekheights.app.util.TankerRules;
import com.geekheights.app.util.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customer {
    private final List<Integer> guests = new ArrayList<>();
    private ResidentConsumptionStrategy strategy;
    Double corporationWater;
    Double borewellWater;

    protected void add(Integer numberOfGuests) {
        this.guests.add(numberOfGuests);
    }
    // Payment of bill
    protected void printBill() {
        //debugBill();
        System.out.println(getGeneratedBill().stream().map(Object::toString).reduce((t, u) -> t + " " + u).orElse(""));
    }
    private void debugBill() {
        int totalNumberOfGuests = this.guests.stream().mapToInt(v -> v).sum();
        System.out.println("Liter "+strategy.executeStrategyAndGetPrice(corporationWater, borewellWater));
        System.out.println("bill "+strategy.executeStrategyAndGetPrice(corporationWater, borewellWater)* AppConstants.PRICE_CORPORATION_WATER.getText());
        System.out.println("Liter "+ Utility.roundToNearestInetegr(strategy.executeStrategyAndGetPrice(borewellWater, corporationWater)));
        System.out.println("bill "+Utility.roundToNearestInetegr(strategy.executeStrategyAndGetPrice(borewellWater, corporationWater)* AppConstants.PRICE_BOREWELL_WATER.getText()));
        System.out.println("Liter "+ GuestBillingStrategy.getBillingStrategy().executeStrategyAndGetPrice(totalNumberOfGuests));
        System.out.println("bill "+ TankerRules.calculatePrice(GuestBillingStrategy.getBillingStrategy().executeStrategyAndGetPrice(totalNumberOfGuests)));
    }
    public List<Integer> getGeneratedBill() {
        int totalNumberOfGuests = this.guests.stream().mapToInt(v -> v).sum();
        int totalLiters = 0;
        totalLiters+=Utility.roundToNearestInetegr(strategy.executeStrategyAndGetPrice(corporationWater, borewellWater));
        totalLiters+=Utility.roundToNearestInetegr(strategy.executeStrategyAndGetPrice(borewellWater, corporationWater));
        totalLiters+=Utility.roundToNearestInetegr(GuestBillingStrategy.getBillingStrategy().executeStrategyAndGetPrice(totalNumberOfGuests));

        int totalBill = 0;
        totalBill+= Utility.roundToNearestInetegr(strategy.executeStrategyAndGetPrice(corporationWater, borewellWater)* AppConstants.PRICE_CORPORATION_WATER.getText());
        totalBill+= Utility.roundToNearestInetegr(strategy.executeStrategyAndGetPrice(borewellWater, corporationWater)* AppConstants.PRICE_BOREWELL_WATER.getText());
        totalBill+= Utility.roundToNearestInetegr(TankerRules.calculatePrice(GuestBillingStrategy.getBillingStrategy().executeStrategyAndGetPrice(totalNumberOfGuests)));
        return Stream.of(totalLiters, totalBill).collect(Collectors.toList());
    }
    // Set Strategy
    protected void setStrategy(ResidentConsumptionStrategy strategy) {
        this.strategy = strategy;
    }
    protected void setRatio(Double corporationWater, Double borewellWater) {
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
