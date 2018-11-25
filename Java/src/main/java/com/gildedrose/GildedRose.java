package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item oneItem : items) {
            processItem(oneItem);
        }
    }

    private void processItem(Item oneItem) {

        if(isSulfaras(oneItem)) {
            return;
        }

        decreaseSellIn(oneItem);

        if (!isAgedBrie(oneItem) && !isConcert(oneItem)) {
            decreaseQuality(oneItem);
        } else {
            increaseQuality(oneItem);
            if (isConcert(oneItem)) {
                if (oneItem.sellIn < 10) {
                    increaseQuality(oneItem);
                }
                if (oneItem.sellIn < 5) {
                    increaseQuality(oneItem);
                }
            }
        }

        if (oneItem.sellIn < 0) {
            if(isAgedBrie(oneItem)) {
                increaseQuality(oneItem);
            }
            else if(isConcert(oneItem)) {
                oneItem.quality = 0;
            } else {
                decreaseQuality(oneItem);
            }
        }
    }

    private void decreaseSellIn(Item oneItem) {
        oneItem.sellIn = oneItem.sellIn - 1;
    }

    private void decreaseQuality(Item oneItem) {
        if (oneItem.quality > 0) {
            oneItem.quality = oneItem.quality - 1;
        }
    }

    private void increaseQuality(Item oneItem) {
        if (oneItem.quality < 50) {
            oneItem.quality = oneItem.quality + 1;
        }
    }

    private boolean isSulfaras(Item oneItem) {
        return oneItem.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConcert(Item oneItem) {
        return oneItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item oneItem) {
        return oneItem.name.equals("Aged Brie");
    }
}