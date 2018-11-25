package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.Assert;
import org.junit.Test;

public class AgedBrieTest {

    private static final String ITEM_NAME = "Aged Brie";
    private static final int ITEM_QUALITY = 3;

    @Test
    public void testAdjustQualitySellByNotPassed() {
        int sellIn = 5;
        AgedBrie agedBrie = AgedBrie.create(setupItem(sellIn));

        agedBrie.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY + 1, agedBrie.item.quality);
    }

    @Test
    public void testAdjustQualitySellByPassed() {
        int sellIn = -1;
        AgedBrie agedBrie = AgedBrie.create(setupItem(sellIn));

        agedBrie.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY + 2, agedBrie.item.quality);
    }

    private Item setupItem(int sellIn) {
        return new Item(ITEM_NAME, sellIn, ITEM_QUALITY);
    }

}