package com.gildedrose.items;

import com.gildedrose.Item;

public class ConcertTicket extends AbstractInventoryItem {

    private static final int STANDARD_INCREASE_RATE = 1;

    private ConcertTicket(final Item item) {
        super(item);
    }

    public static ConcertTicket create(final Item item) {
        return new ConcertTicket(item);
    }

    @Override
    public void adjustQuality() {
        if (isSellByPassed()) {
            item.quality = 0;
        } else {
            adjustQualityWhenSellByNotPassed();
        }
    }

    private void adjustQualityWhenSellByNotPassed() {
        int increaseRate = STANDARD_INCREASE_RATE;
        if (item.sellIn < 10) {
            increaseRate = STANDARD_INCREASE_RATE * 2;
        }
        if (item.sellIn < 5) {
            increaseRate = STANDARD_INCREASE_RATE * 3;
        }
       increaseQuality(increaseRate);
    }
}
