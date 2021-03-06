package com.gildedrose.items;

import static com.gildedrose.items.StandardItem.DEFAULT_DECREASE_RATE;

import com.gildedrose.Item;

public class ConjuredItem extends AbstractInventoryItem {

    private ConjuredItem(final Item item) {
        super(item);
    }

    public static ConjuredItem create(final Item item) {
        return new ConjuredItem(item);
    }

    @Override
    public void adjustQuality() {
        int decreaseRate = DEFAULT_DECREASE_RATE * 2;
        if(isSellByDatePassed()) {
            decreaseRate *= 2;
        }
        decreaseQuality(decreaseRate);
    }
}
