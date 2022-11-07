package com.javatunes.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Objects;

public class EmployeeTest {

    private SalariedEmployee salariedEmployee1;
    private SalariedEmployee salariedEmployee2;

    @Before
    public void setUp() throws Exception {
        salariedEmployee1 = new SalariedEmployee("Steve", Date.valueOf("2012-05-12"), 2_000.00);
        salariedEmployee2 = new SalariedEmployee("Ben", Date.valueOf("2015-05-12"), 2_500.00);
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(false, salariedEmployee1.equals(salariedEmployee2));
    }

//    @Test
//    public void testHashCode() {
//        Assert.assertEquals(905049251, Objects.hash(salariedEmployee1, salariedEmployee2));
//    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(-632756548, salariedEmployee1.hashCode());
    }
}
