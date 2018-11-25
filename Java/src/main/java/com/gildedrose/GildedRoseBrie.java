package com.gildedrose;

public class GildedRoseBrie implements GildedRoseItem {

    private Item item;

    public GildedRoseBrie(Item item) {
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
