package com.javatunes.personnel;

import gov.irs.TaxPayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    private SalariedEmployee salariedEmployee;

    @Before
    public void setUp() throws Exception {
         salariedEmployee = new SalariedEmployee("Bob", Date.valueOf("1996-10-21"), 25_000.00);
    }

    @Test
    public void testPay() {
        Assert.assertEquals(25000.00, salariedEmployee.getSalary(), 0.001);
    }

    @Test
    public void payTaxes() {
        double expectedValue = 0.3 * 25_000.00;
        Assert.assertEquals(expectedValue, (salariedEmployee.getSalary()*SalariedEmployee.SALARIED_TAX_RATE),
                0.001);
    }
}