package com.gildedrose.items;

import com.gildedrose.Item;

public abstract  class AbstractInventoryItem implements  InventoryItem {

    protected final Item item;

    public AbstractInventoryItem(final Item item) {
        this.item = item;
    }

    @Override
    public void decreaseSellByDate() {
        item.sellIn--;
    }

    protected boolean isSellByDatePassed() {
        return item.sellIn < 0;
    }

    protected void increaseQuality(int increaseRate) {
        item.quality = Quality.create(item.quality).increase(increaseRate).value();
    }

    protected void decreaseQuality(int decreaseRate) {
        item.quality = Quality.create(item.quality).decrease(decreaseRate).value();
    }
}
