package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie implements GildedRoseItem {

    private Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        increaseQuality();
        if(item.sellIn < 0) {
            increaseQuality();
        }
    }

    private void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
