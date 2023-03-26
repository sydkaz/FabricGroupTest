package com.geekheights.app.strategy;

import com.geekheights.app.consts.AppConstants;

public interface GuestBillingStrategy {
    Double getActPrice(Integer numberOfGuests);

    static GuestBillingStrategy getBillingStrategy() {
        return (numberOfGuests) ->  numberOfGuests * AppConstants.MAX_LITERS_PER_PERSON.getText() * AppConstants.NO_OF_DAYS.getText();
    }
}
