package com.entertainment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TelevisionBrandChannelComparatorTest {

    private Television television1;
    private Television television2;
    private TelevisionBrandChannelComparator comp1;

    @Before
    public void setUp() throws Exception {
        television1 = new Television("Toshiba");
        television2 = new Television("Sony");
        comp1 = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare() {
        Assert.assertEquals(1, comp1.compare(television1, television2));

    }
}
