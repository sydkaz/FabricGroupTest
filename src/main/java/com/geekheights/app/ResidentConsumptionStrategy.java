package com.geekheights.app;

import com.geekheights.app.consts.AppConstants;

public interface ResidentConsumptionStrategy {
    Double getActPrice(Double ratioA, Double ratioB);

    static ResidentConsumptionStrategy _2BHKStrategy() {
        return (ratioA,ratioB) -> (ratioA / (ratioA+ratioB)) * (AppConstants._2BHK.getText() * AppConstants.MAX_LITERS_PER_PERSON.getText() * AppConstants.NO_OF_DAYS.getText());
    }

    static ResidentConsumptionStrategy _3BHKStrategy() {
        return (ratioA,ratioB) -> (ratioA / (ratioA+ratioB)) * (AppConstants._3BHK.getText() * AppConstants.MAX_LITERS_PER_PERSON.getText() * AppConstants.NO_OF_DAYS.getText());
    }
}
