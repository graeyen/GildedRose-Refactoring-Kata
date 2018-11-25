package com.gildedrose.items;

import com.gildedrose.Item;

public abstract  class AbstractInventoryItem implements  InventoryItem {

    protected final Item item;

    public AbstractInventoryItem(final Item item) {
        this.item = item;
    }

    @Override
    public void adjustSellIn() {
        item.sellIn--;
    }
}
