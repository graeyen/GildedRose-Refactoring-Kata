package com.gildedrose.items;

import com.gildedrose.Item;
import org.junit.Assert;
import org.junit.Test;

public class StandardItemTest {

    private static final String ITEM_NAME = "Standard item";
    private static final int ITEM_QUALITY = 3;

    @Test
    public void testAdjustQualitySellByNotPassed() {
        int sellIn = 5;
        StandardItem standardItem = StandardItem.create(setupItem(sellIn));

        standardItem.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY - 1, standardItem.item.quality);
    }

    @Test
    public void testAdjustQualitySellByPassed() {
        int sellIn = -1;
        StandardItem standardItem = StandardItem.create(setupItem(sellIn));

        standardItem.adjustQuality();
        Assert.assertEquals(ITEM_QUALITY - 2, standardItem.item.quality);
    }

    @Test
    public void testAdjustQualitySellByPassedAndQualityAlmostZero() {
        int sellIn = -1;
        int quality = 1;
        StandardItem standardItem = StandardItem.create(setupItem(sellIn, quality));

        standardItem.adjustQuality();
        Assert.assertEquals(0, standardItem.item.quality);
    }

    private Item setupItem(int sellIn) {
        return setupItem(sellIn, ITEM_QUALITY);
    }

    private Item setupItem(int sellIn, int quality) {
        return new Item(ITEM_NAME, sellIn, quality);
    }

}