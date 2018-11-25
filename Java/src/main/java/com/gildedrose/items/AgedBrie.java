package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends AbstractInventoryItem {

    private static final int STANDARD_INCREASE_RATE = 1;
    private static final int ACCELERATED_INCREASE_RATE = 2;

    private AgedBrie(final Item item) {
        super(item);
    }

    public static AgedBrie create(final Item item) {
        return new AgedBrie(item);
    }

    @Override
    public void adjustQuality() {
        int increaseRate = STANDARD_INCREASE_RATE;
        if(item.sellIn < 0) {
            increaseRate = ACCELERATED_INCREASE_RATE;
        }
        item.quality = Quality.create(item.quality).increase(increaseRate).value();
    }

}
