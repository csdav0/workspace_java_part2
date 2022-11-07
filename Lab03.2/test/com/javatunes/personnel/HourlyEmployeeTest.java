package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    @Before
    public void setUp() throws Exception {
        hourlyEmployee = new HourlyEmployee("Cameron", Date.valueOf("2022-11-1"), 65.0, 40.0);
    }

    @Test
    public void testPay() {
        assertEquals((65 * 40), hourlyEmployee.getRate() * hourlyEmployee.getHours(), 0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals((65 * 40 * 0.25),
                (hourlyEmployee.getRate() * hourlyEmployee.getHours() * HourlyEmployee.HOURLY_TAX_RATE), 0.001);
    }
}