package com.entertainment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {

    private Television television;
    private Television other;

    @Before
    public void setUp() throws Exception {
        television = new Television("Sony", 90, DisplayType.LED);
        other = new Television("Sony", 85, DisplayType.OLED);
    }

    @Test
    public void testSetVolume_when_volume_input_is_valid_entry() {
        television.setVolume(90);
        Assert.assertEquals(90, television.getVolume());
    }

    @Test
    public void testSetVolume_when_volume_input_is_too_low() {
        try {
            television.setVolume(-5);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid volume: -5. Allowed range: [0,100].", e.getMessage());
        }
    }

    @Test
    public void testSetVolume_when_volume_input_is_too_high() {
        try {
            television.setVolume(105);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid volume: 105. Allowed range: [0, 100].", e.getMessage());
        }
    }

    @Test
    public void testChangeChannel_when_channel_input_is_valid_entry() throws InvalidChannelException {
        television.changeChannel(56);
        Assert.assertEquals(56, television.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void testChangeChannel_when_channel_input_is_too_low() throws InvalidChannelException {
        television.changeChannel(-6);
    }

    @Test(expected = InvalidChannelException.class)
    public void testChangeChannel_when_channel_input_is_too_high() throws InvalidChannelException {
        television.changeChannel(10000);
    }

    @Test
    public void testCompareTo() {
        Assert.assertEquals(0, television.compareTo(other));
    }

    @Test
    public void testHashCode() {
        Assert.assertTrue(television.hashCode() == other.hashCode());
    }

    @Test
    public void testEquals() {
        Assert.assertEquals(false, television.equals(other));
    }
}
