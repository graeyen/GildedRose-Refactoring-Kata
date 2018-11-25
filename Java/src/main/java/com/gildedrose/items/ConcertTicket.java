package com.gildedrose.items;

import com.gildedrose.Item;

public class ConcertTicket implements GildedRoseItem {

    private Item item;

    public ConcertTicket(Item item) {
        this.item = item;
    }

    @Override
    public void adjustQuality() {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {increaseQuality();

            if (item.sellIn < 10) {
               increaseQuality();
            }
            if (item.sellIn < 5) {
                increaseQuality();
            }

        }
    }

    private void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
