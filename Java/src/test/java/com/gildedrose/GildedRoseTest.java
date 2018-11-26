package com.gildedrose;

import static org.junit.Assert.assertEquals;

import com.gildedrose.items.Quality;
import org.junit.Test;

public class GildedRoseTest {

    private static final String ITEM_NAME_AGED_BRIE = "Aged Brie";

    private static final String ITEM_NAME_TICKET = "Backstage passes to a TAFKAL80ETC concert";

    private static final String ITEM_NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int ITEM_QUALITY_SULFURAS = 80;

    private static final int ITEM_SELL_IN_PASSED = -1;

    @Test
    public void testUpdateQuality() {
        Item[] items = new Item[] { new Item("item", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("item", app.items[0].name);
    }

    @Test
    public void testUpdateQualityWithStandardItemWhenSellByDateNotPassed() {
        int itemSellIn = 5;
        int itemQuality = 4;
        Item[] items = new Item[] { new Item("standard item", itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality-1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithStandardItemWhenSellByDatePassed() {
        int itemQuality = 3;
        Item[] items = new Item[] { new Item("standard item", ITEM_SELL_IN_PASSED, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(itemQuality-2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithStandardItemWhenSellByDatePassedAndQualityAllmostZero() {
        int itemQuality = 1;
        Item[] items = new Item[] { new Item("standard item", ITEM_SELL_IN_PASSED, itemQuality)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(Quality.MIN_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithStandardItemWhenSellByDatePassedPAndQualityZero() {
        Item[] items = new Item[] { new Item("standard item", ITEM_SELL_IN_PASSED, Quality.MIN_VALUE) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(Quality.MIN_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByDateNotPassed() {
        int itemSellIn = 5;
        int itemQuality = 4;
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByDatePassed() {
        int itemQuality = 48;
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_SELL_IN_PASSED-1, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(ITEM_SELL_IN_PASSED -2, app.items[0].sellIn);
        assertEquals(Quality.MAX_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByDatePassedAndQualityNearMax() {
        int itemQuality = 49;
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_SELL_IN_PASSED, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(Quality.MAX_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithBrieWhenSellByPassedAndMaxQuality() {
        Item[] items = new Item[] { new Item(ITEM_NAME_AGED_BRIE, ITEM_SELL_IN_PASSED, Quality.MAX_VALUE) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(Quality.MAX_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhenMoreThan11DaysLeft() {
        int itemSellIn = 12;
        int itemQuality = 6;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen11DaysLeft() {
        int itemSellIn = 11;
        int itemQuality = 6;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+1, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen10DaysLeft() {
        int itemSellIn = 10;
        int itemQuality = 6;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+2, app.items[0].quality);
    }



    @Test
    public void testUpdateQualityWithTicketWhenLessThan10DaysAndMoreThan6DaysLeft() {
        int itemSellIn = 8;
        int itemQuality = 48;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen6DaysLeft() {
        int itemSellIn = 6;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen5DaysLeft() {
        int itemSellIn = 5;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality+3, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhen5DaysLeftAndMaxQuality() {
        int itemSellIn = 5;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, itemSellIn, Quality.MAX_VALUE) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(Quality.MAX_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithTicketWhenSellByDatePassed() {
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(ITEM_NAME_TICKET, ITEM_SELL_IN_PASSED, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(Quality.MIN_VALUE, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithSulfurasWhenSellByDateNotPassed() {
        int itemSellIn = 6;
        doTestUpdateQualityWithSulfurasForSellIn(itemSellIn);
    }

    @Test
    public void testUpdateQualityWithSulfurasWhenSellByZero() {
        doTestUpdateQualityWithSulfurasForSellIn(ITEM_SELL_IN_PASSED);
    }


    @Test
    public void testUpdateQualityWithConjuredItemWhenSellByDateNotPassed() {
        int itemSellIn = 5;
        int itemQuality = 4;
        Item[] items = new Item[] { new Item("Conjured item", itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(itemSellIn, app.items[0]);
        assertEquals(itemQuality-2, app.items[0].quality);
    }

    @Test
    public void testUpdateQualityWithConjuredItemWhenSellByDatePassed() {
        int itemQuality = 5;
        Item[] items = new Item[] { new Item("Conjured item", ITEM_SELL_IN_PASSED, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertSellByDateDecreased(ITEM_SELL_IN_PASSED, app.items[0]);
        assertEquals(itemQuality-4, app.items[0].quality);
    }

    private void assertSellByDateDecreased(int originalSellIn, Item item) {
        int expectedSellIn = originalSellIn-1;
        assertEquals(expectedSellIn, item.sellIn);
    }

    private void doTestUpdateQualityWithSulfurasForSellIn(int itemSellIn) {
        Item[] items = new Item[] { new Item(ITEM_NAME_SULFURAS, itemSellIn, ITEM_QUALITY_SULFURAS) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(itemSellIn, app.items[0].sellIn);
        assertEquals(ITEM_QUALITY_SULFURAS, app.items[0].quality);
    }

}
