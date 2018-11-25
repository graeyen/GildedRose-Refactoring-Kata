package com.gildedrose.items;

import com.gildedrose.Item;

public class StandardItem implements GildedRoseItem {

    public static final int STANDARD_DECREASE_RATE = 1;

    private Item item;

    private StandardItem(final Item item) {
        this.item = item;
    }

    public static StandardItem create(final Item item) {
        return new StandardItem(item);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void adjustQuality() {
        int decreaseRate = STANDARD_DECREASE_RATE;
        if (item.sellIn < 0) {
            decreaseRate = decreaseRate*2;
        }
        item.quality = Quality.create(item.quality).decrease(decreaseRate).value();
    }
}
