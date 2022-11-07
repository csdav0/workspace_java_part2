package com.entertainment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {

    @Test
    public void compare() throws InvalidChannelException {

        TelevisionChannelComparator comparator = new TelevisionChannelComparator();
        Television tv1 = new Television("Sony");
        tv1.changeChannel(125);
        Television tv2 = new Television("Samsung");
        tv2.changeChannel(75);

        Assert.assertEquals(1, comparator.compare(tv1, tv2));
    }
}