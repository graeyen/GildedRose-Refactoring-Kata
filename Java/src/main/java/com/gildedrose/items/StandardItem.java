package com.gildedrose.items;

import com.gildedrose.Item;

public class StandardItem implements GildedRoseItem {

    private Item item;

    public StandardItem(Item item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        decreaseQuality();
        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
