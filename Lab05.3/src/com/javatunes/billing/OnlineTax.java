/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.billing;

/**
 * Online orders are tax-free!
 * 
 * TODO: implement this algorithm.
 */
public class OnlineTax implements TaxCalculator {

    public static final double ONLINE_TAX_AMOUNT = 0.0;

    @Override
    public double taxAmount(double taxable) {
        return ONLINE_TAX_AMOUNT;
    }
}