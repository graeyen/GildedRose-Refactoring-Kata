package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends AbstractInventoryItem {

    private static final int STANDARD_INCREASE_RATE = 1;

    private AgedBrie(final Item item) {
        super(item);
    }

    public static AgedBrie create(final Item item) {
        return new AgedBrie(item);
    }

    @Override
    public void adjustQuality() {
        int increaseRate = STANDARD_INCREASE_RATE;
        if(isSellByPassed()) {
            increaseRate *= 2;
        }
        increaseQuality(increaseRate);
    }

}
