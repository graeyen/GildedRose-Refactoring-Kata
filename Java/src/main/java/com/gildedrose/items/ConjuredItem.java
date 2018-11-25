package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredItem implements GildedRoseItem {

    private Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        decreaseQuality();
        decreaseQuality();
        if (item.sellIn < 0) {
            decreaseQuality();
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
