package com.gildedrose.items;

import com.gildedrose.Item;

public class StandardItem extends AbstractInventoryItem {

    public static final int DEFAULT_DECREASE_RATE = 1;

    private StandardItem(final Item item) {
        super(item);
    }

    public static StandardItem create(final Item item) {
        return new StandardItem(item);
    }

    @Override
    public void adjustQuality() {
        int decreaseRate = DEFAULT_DECREASE_RATE;
        if (isSellByDatePassed()) {
            decreaseRate *= 2;
        }
        decreaseQuality(decreaseRate);
    }
}
