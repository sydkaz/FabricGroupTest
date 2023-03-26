package com.geekheights.app.strategy;

import com.geekheights.app.consts.AppConstants;

import java.util.function.Function;

public interface ResidentConsumptionStrategy {
    Double getActPrice(Double ratioA, Double ratioB);

    static Function<String,AppConstants> getType(){
        return (a)-> a.equals("2") ? AppConstants._2BHK : a.equals("3") ?  AppConstants._2BHK  : null;
    }
    static ResidentConsumptionStrategy getStrategy(String strategy) {

        return (ratioA,ratioB) -> (ratioA / (ratioA+ratioB)) * ( getType().apply(strategy).getText() ) * AppConstants.MAX_LITERS_PER_PERSON.getText() * AppConstants.NO_OF_DAYS.getText();
    }


}
