package com.gildedrose.items;

import com.gildedrose.Item;

public class ConcertTicket implements GildedRoseItem {

    private static final int STANDARD_INCREASE_RATE = 1;
    private static final int ACCELERATED_INCREASE_RATE = 2;
    private static final int SUPER_INCREASE_RATE = 3;

    private Item item;

    private ConcertTicket(final Item item) {
        this.item = item;
    }

    public static ConcertTicket create(final Item item) {
        return new ConcertTicket(item);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void adjustQuality() {
        if (isSellByPassed()) {
            item.quality = 0;
        } else {
            adjustQualityWhenSellByNotPassed();
        }
    }

    private boolean isSellByPassed() {
        return item.sellIn < 0;
    }

    private void adjustQualityWhenSellByNotPassed() {
        int increaseRate = STANDARD_INCREASE_RATE;
        if (item.sellIn < 10) {
            increaseRate = ACCELERATED_INCREASE_RATE;
        }
        if (item.sellIn < 5) {
            increaseRate = SUPER_INCREASE_RATE;
        }
        item.quality = Quality.create(item.quality).increase(increaseRate).value();
    }
}
