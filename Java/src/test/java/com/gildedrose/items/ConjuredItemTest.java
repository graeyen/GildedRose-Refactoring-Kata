package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.Assert;
import org.junit.Test;

public class ConjuredItemTest {

    private static final String ITEM_NAME = "Conjured item";
    private static final int ITEM_QUALITY = 8;

    @Test
    public void testAdjustQualitySellByNotPassed() {
        int sellIn = 5;
        ConjuredItem conjuredItem = ConjuredItem.create(setupItem(sellIn));

        conjuredItem.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY - 2, conjuredItem.item.quality);
    }

    @Test
    public void testAdjustQualitySellByPassed() {
        int sellIn = -1;
        ConjuredItem conjuredItem = ConjuredItem.create(setupItem(sellIn));

        conjuredItem.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY - 4, conjuredItem.item.quality);
    }

    @Test
    public void testAdjustQualitySellByPassedAndQualityAlmostZero() {
        int sellIn = -1;
        int quality = 1;
        ConjuredItem conjuredItem = ConjuredItem.create(setupItem(sellIn, quality));

        conjuredItem.adjustQuality();
        Assert.assertEquals(0, conjuredItem.item.quality);
    }

    private Item setupItem(int sellIn) {
        return setupItem(sellIn, ITEM_QUALITY);
    }

    private Item setupItem(int sellIn, int quality) {
        return new Item(ITEM_NAME, sellIn, quality);
    }

}