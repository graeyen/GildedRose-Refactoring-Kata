package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.Assert;
import org.junit.Test;

public class ConcertTicketTest {

    private static final String ITEM_NAME = "Concert ticket";
    private static final int ITEM_QUALITY = 3;
    private static final int ITEM_QUALITY_MAX = 50;

    @Test
    public void testAdjustQualitySellBy10Days() {
        int sellIn = 10;
        ConcertTicket concertTicket = ConcertTicket.create(setupItem(sellIn));

        concertTicket.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY + 1, concertTicket.item.quality);
    }

    @Test
    public void testAdjustQualitySellBy5Days() {
        int sellIn = 5;
        ConcertTicket concertTicket = ConcertTicket.create(setupItem(sellIn));

        concertTicket.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY + 2, concertTicket.item.quality);
    }

    @Test
    public void testAdjustQualitySellBy4Days() {
        int sellIn = 4;
        ConcertTicket concertTicket = ConcertTicket.create(setupItem(sellIn));

        concertTicket.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY + 3, concertTicket.item.quality);
    }

    @Test
    public void testAdjustQualitySellBy4DaysAndQualityAlmostMax() {
        int sellIn = 4;
        int quality = ITEM_QUALITY_MAX - 2;
        ConcertTicket concertTicket = ConcertTicket.create(setupItem(sellIn, quality));

        concertTicket.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY_MAX, concertTicket.item.quality);
    }

    private Item setupItem(int sellIn) {
        return setupItem(sellIn, ITEM_QUALITY);
    }

    private Item setupItem(int sellIn, int quality) {
        return new Item(ITEM_NAME, sellIn, quality);
    }

}