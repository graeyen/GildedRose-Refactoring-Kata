package com.gildedrose.items;

/**
 * An item part of the Gilded Rose inventory.
 */
public interface InventoryItem {

    /**
     * Decreases the sell in of this item by 1.
     */
    void decreaseSellByDate();

    /**
     * Adjusts the quality of this item.
     */
    void adjustQuality();

}
