package com.javatunes.product;

import com.javatunes.billing.EuropeTax;
import com.javatunes.billing.OnlineTax;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.USATax;

public class OrderFactory {

    private TaxCalculator USATax;
    private TaxCalculator EuropeTax;
    private TaxCalculator OnlineTax;

    public Order createOrder(String id, String taxString) {

        Order myOrder = null;
        if (taxString.equals("USA")) {
            myOrder = new Order(id, new USATax());
        } else if (taxString.equals("Europe")) {
            myOrder = new Order(id, new EuropeTax());
        } else if (taxString.equals("Online")) {
            myOrder = new Order(id, new OnlineTax());
        } else {
            throw new IllegalArgumentException("Select taxString from: USA, Europe, Online");
        }
        return myOrder;
    }
}
