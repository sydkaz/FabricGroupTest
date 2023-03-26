package com.geekheights.app.consts;

public enum AppConstants {
    NO_OF_DAYS(30.0),
    MAX_LITERS_PER_PERSON(10.0),
    PRICE_CORPORATION_WATER(1.0),
    PRICE_BOREWELL_WATER(1.5),
    _2BHK(3.0),
    _3BHK(5.0);

    private Double text;


    AppConstants(Double number) {
        this.text = number;
    }
    public Double getText() {
        return this.text;
    }

    public static AppConstants fromString(String text) {
        for (AppConstants pt : AppConstants.values()) {
            if (text.equalsIgnoreCase(pt.text+"")) {
                return pt;
            }
        }
        return null;
    }
}
