package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private static final String ITEM_NAME_AGED_BRIE = "Aged Brie";
    private static final String ITEM_NAME_TICKET = "Backstage passes to a TAFKAL80ETC concert";
    private static final String ITEM_NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int ITEM_QUALITY_MAX = 50;
    private static final int ITEM_QUALITY_ZERO = 0;
    private static final int ITEM_QUALITY_SULFURAS = 80;

    private static final int ITEM_ZERO_SELL_IN = 0;

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void testUpdateQualityWithStandardItemWhenSellByNotPassed() {
        int itemSellIn = 5;
        int itemQuality = 4;
        Item[] items = new Item[] { new Item("standard item", itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(itemQuality-1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithStandardItemAndSellByWillPass() {
        int itemQuality = 3;
        Item[] items = new Item[] { new Item("standard item", 0, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(itemQuality-2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithStandardItemAndSellByWillPassAndQualityLower2() {
        int itemQuality = 1;
        Item[] items = new Item[] { new Item("standard item", 0, itemQuality)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_ZERO, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithStandardItemAndSellByWillPassAndQualityZero() {
        Item[] items = new Item[] { new Item("standard item", 0, ITEM_QUALITY_ZERO) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_ZERO, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByNotPassed() {
        int itemSellIn = 5;
        int itemQuality = 4;
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(itemQuality+1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByWillPass() {
        int itemQuality = 49;
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_ZERO_SELL_IN, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(ITEM_ZERO_SELL_IN -1, app.items[0].sellIn);
        assertEquals(itemQuality+1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByPassed() {
        int itemQuality = 48;
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_ZERO_SELL_IN -1, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(ITEM_ZERO_SELL_IN -2, app.items[0].sellIn);
        assertEquals(itemQuality+2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByPassedAndMaxQuality() {
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_ZERO_SELL_IN -1, ITEM_QUALITY_MAX) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(ITEM_ZERO_SELL_IN -2, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_MAX, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenMaxQuality() {
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_ZERO_SELL_IN, ITEM_QUALITY_MAX) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(ITEM_ZERO_SELL_IN -1, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_MAX, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhenMoreThan10DaysLeft() {
        int itemSellIn = 12;
        int itemQuality = 6;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(itemQuality+1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen10DaysLeft() {
        int itemSellIn = 10;
        int itemQuality = 6;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(itemQuality+2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhenLessThan10DaysAndMoreThan5DaysLeft() {
        int itemSellIn = 8;
        int itemQuality = 48;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(itemQuality+2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen5DaysLeft() {
        int itemSellIn = 5;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(itemQuality+3, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen5DaysLeftAndMaxQuality() {
        int itemSellIn = 5;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, ITEM_QUALITY_MAX) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn-1, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_MAX, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhenSellByPassed() {
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, ITEM_ZERO_SELL_IN, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(ITEM_ZERO_SELL_IN -1, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_ZERO, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithSulfurasWhenSellByNotPassed() {
        int itemSellIn = 6;
        doTestUpdateQualityWithSulfurasForSellIn(itemSellIn);
    }

    @Test
    public void testUpdateQualityWithSulfurasWhenSellByZero() {
        doTestUpdateQualityWithSulfurasForSellIn(ITEM_ZERO_SELL_IN);
    }

    @Test
    public void testUpdateQualityWithSulfurasWhenSellByPassed() {
        int itemSellIn = -2;
        doTestUpdateQualityWithSulfurasForSellIn(itemSellIn);
    }

    private void doTestUpdateQualityWithSulfurasForSellIn(int itemSellIn) {
        Item[] items = new Item[] { new Item(ITEM_NAME_SULFURAS, itemSellIn, ITEM_QUALITY_SULFURAS) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_SULFURAS, app.items[0].quality);
    }

}
