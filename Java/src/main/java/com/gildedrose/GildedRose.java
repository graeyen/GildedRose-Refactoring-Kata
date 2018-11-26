package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.ConcertTicket;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.InventoryItem;
import com.gildedrose.items.StandardItem;

class GildedRose {
    private InventoryItemFactory inventoryItemFactory = new InventoryItemFactory();

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item oneItem : items) {
            updateQuality(oneItem);
        }
    }

    private void updateQuality(Item oneItem) {
        if(isNotLegendary(oneItem)) {
            adjustItem(oneItem);
        }
    }

    private void adjustItem(Item oneItem) {
        InventoryItem inventoryItem = inventoryItemFactory.create(oneItem);
        inventoryItem.decreaseSellByDate();
        inventoryItem.adjustQuality();
    }

    private boolean isNotLegendary(Item oneItem) {
        return !oneItem.name.startsWith("Sulfuras");
    }

    private class InventoryItemFactory {
        private InventoryItem create(Item item) {

            if(isAgedBrie(item)) {
                return AgedBrie.create(item);
            }
            if(isConcert(item)) {
                return ConcertTicket.create(item);
            }
            if(isConjured(item)) {
                return ConjuredItem.create(item);
            }
            return StandardItem.create(item);
        }

        private boolean isConcert(Item oneItem) {
            return oneItem.name.startsWith("Backstage passes");
        }

        private boolean isAgedBrie(Item oneItem) {
            return oneItem.name.equals("Aged Brie");
        }

        private boolean isConjured(Item oneItem) {
            return oneItem.name.startsWith("Conjured");
        }
    }
}