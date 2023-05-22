package com.simvoly.currencyRate.model;

import java.util.HashMap;
import java.util.Map;

public enum Currency {
    EUR("USD/EUR"), GBP("USD/GBP");

    public final String label;

    private static final Map<String, Currency> BY_LABEL = new HashMap<>();

    static {
        for (final Currency currency: values()){
            BY_LABEL.put(currency.label, currency);
        }
    }
    private Currency(String label){
        this.label = label;
    }

    public static Currency findByLabel(final String label){
        return BY_LABEL.get(label);
    }
}
