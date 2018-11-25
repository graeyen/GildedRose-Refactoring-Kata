package com.gildedrose;

public class GildedRoseStandardItem implements GildedRoseItem {

    private Item item;

    public GildedRoseStandardItem(Item item) {
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
