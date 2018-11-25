package com.gildedrose.items;

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
        int decreaseRate = StandardItem.STANDARD_DECREASE_RATE * 2;
        if(item.sellIn < 0) {
            decreaseRate = decreaseRate * 2;
        }
        item.quality = Quality.create(item.quality).decrease(decreaseRate).value();
    }
}
