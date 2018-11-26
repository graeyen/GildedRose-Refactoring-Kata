package com.gildedrose.items;

import static com.gildedrose.items.StandardItem.DEFAULT_DECREASE_RATE;

import com.gildedrose.Item;

public class ConcertTicket extends AbstractInventoryItem {

    private ConcertTicket(final Item item) {
        super(item);
    }

    public static ConcertTicket create(final Item item) {
        return new ConcertTicket(item);
    }

    @Override
    public void adjustQuality() {
        if (isSellByDatePassed()) {
            item.quality = 0;
        } else {
            adjustQualityWhenSellByNotPassed();
        }
    }

    private void adjustQualityWhenSellByNotPassed() {
        int increaseRate = DEFAULT_DECREASE_RATE;
        if (item.sellIn < 10) {
            increaseRate = DEFAULT_DECREASE_RATE * 2;
        }
        if (item.sellIn < 5) {
            increaseRate = DEFAULT_DECREASE_RATE * 3;
        }
       increaseQuality(increaseRate);
    }
}
