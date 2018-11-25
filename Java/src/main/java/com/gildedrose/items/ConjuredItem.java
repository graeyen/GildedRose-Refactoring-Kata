package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItem implements GildedRoseItem {

    private Item item;

    private ConjuredItem(final Item item) {
        this.item = item;
    }

    public static ConjuredItem create(final Item item) {
        return new ConjuredItem(item);
    }

    public Item getItem() {
        return item;
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
