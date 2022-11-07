package com.javatunes.product;

import com.javatunes.billing.EuropeTax;
import com.javatunes.billing.OnlineTax;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.USATax;

public class OrderFactory {

    private static TaxCalculator USATax;
    private static TaxCalculator EuropeTax;
    private static TaxCalculator OnlineTax;

    public static TaxCalculator createTaxStrategy(String myTaxReference) {

        if (myTaxReference.equals("USATax")) {
            return new USATax();
        } else if (myTaxReference.equals("EuropeTax")) {
            return new EuropeTax();
        } else if (myTaxReference.equals("OnlineTax")) {
            return new OnlineTax();
        }
        throw new IllegalArgumentException("Select strategy from: USATax, EuropeTax, OnlineTax");
    }
}
