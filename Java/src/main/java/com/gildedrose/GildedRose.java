package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.ConcertTicket;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.InventoryItem;
import com.gildedrose.items.StandardItem;

class GildedRose {
    private ItemFactory itemFactory = new ItemFactory();

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
        InventoryItem inventoryItem = itemFactory.create(oneItem);
        inventoryItem.adjustSellIn();
        inventoryItem.adjustQuality();
    }

    private boolean isSulfaras(Item oneItem) {
        return oneItem.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private class ItemFactory {
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

        private boolean isSulfaras(Item oneItem) {
            return oneItem.name.equals("Sulfuras, Hand of Ragnaros");
        }

        private boolean isConcert(Item oneItem) {
            return oneItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
        }

        private boolean isAgedBrie(Item oneItem) {
            return oneItem.name.equals("Aged Brie");
        }

        private boolean isConjured(Item oneItem) {
            return oneItem.name.startsWith("Conjured");
        }
    }
}