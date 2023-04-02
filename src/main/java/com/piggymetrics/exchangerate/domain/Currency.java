package com.piggymetrics.exchangerate.domain;

public enum Currency {

    USD, EUR, RUB;

    public static Currency getBase() {
        return USD;
    }
}
