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

        GildedRoseItem gildedRoseItem = createGildedRoseItem(oneItem);
        gildedRoseItem.adjustQuality();
    }

    private GildedRoseItem createGildedRoseItem(Item oneItem) {
        GildedRoseItem gildedRoseItem;

        if(isAgedBrie(oneItem)) {
            gildedRoseItem = new GildedRoseBrie(oneItem);
        } else if(isConcert(oneItem)) {
            gildedRoseItem = new GildedRoseConcertTicket(oneItem);
        } else {
            gildedRoseItem = new GildedRoseStandardItem(oneItem);
        }
        return gildedRoseItem;
    }

    private void decreaseSellIn(Item oneItem) {
        oneItem.sellIn = oneItem.sellIn - 1;
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