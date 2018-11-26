package com.gildedrose.items;

import static com.gildedrose.items.StandardItem.DEFAULT_DECREASE_RATE;

import com.gildedrose.Item;

public class AgedBrie extends AbstractInventoryItem {

    private AgedBrie(final Item item) {
        super(item);
    }

    public static AgedBrie create(final Item item) {
        return new AgedBrie(item);
    }

    @Override
    public void adjustQuality() {
        int increaseRate = DEFAULT_DECREASE_RATE;
        if(isSellByDatePassed()) {
            increaseRate *= 2;
        }
        increaseQuality(increaseRate);
    }
}
