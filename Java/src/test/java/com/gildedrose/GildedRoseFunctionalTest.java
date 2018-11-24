package com.gildedrose;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GildedRoseFunctionalTest {

    private Item[] items;

    private GildedRose app = new GildedRose(items);

    private static List<int[]> EXPECTED_SELL_INS_FOR_30_DAYS;

    private static List<int[]> EXPECTED_QUALITIES_FOR_30_DAYS;

    static {
        EXPECTED_SELL_INS_FOR_30_DAYS = new ArrayList<>();
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{10, 2, 5, 0, -1, 15, 10, 5, 3});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{9, 1, 4, 0, -1, 14, 9, 4, 2});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{8, 0, 3, 0, -1, 13, 8, 3, 1});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{7, -1, 2, 0, -1, 12, 7, 2, 0});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{6, -2, 1, 0, -1, 11, 6, 1, -1});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{5, -3, 0, 0, -1, 10, 5, 0, -2});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{4, -4, -1, 0, -1, 9, 4, -1, -3});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{3, -5, -2, 0, -1, 8, 3, -2, -4});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{2, -6, -3, 0, -1, 7, 2, -3, -5});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{1, -7, -4, 0, -1, 6, 1, -4, -6});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{0, -8, -5, 0, -1, 5, 0, -5, -7});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-1, -9, -6, 0, -1, 4, -1, -6, -8});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-2, -10, -7, 0, -1, 3, -2, -7, -9});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-3, -11, -8, 0, -1, 2, -3, -8, -10});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-4, -12, -9, 0, -1, 1, -4, -9, -11});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-5, -13, -10, 0, -1, 0, -5, -10, -12});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-6, -14, -11, 0, -1, -1, -6, -11, -13});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-7, -15, -12, 0, -1, -2, -7, -12, -14});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-8, -16, -13, 0, -1, -3, -8, -13, -15});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-9, -17, -14, 0, -1, -4, -9, -14, -16});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-10, -18, -15, 0, -1, -5, -10, -15, -17});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-11, -19, -16, 0, -1, -6, -11, -16, -18});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-12, -20, -17, 0, -1, -7, -12, -17, -19});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-13, -21, -18, 0, -1, -8, -13, -18, -20});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-14, -22, -19, 0, -1, -9, -14, -19, -21});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-15, -23, -20, 0, -1, -10, -15, -20, -22});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-16, -24, -21, 0, -1, -11, -16, -21, -23});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-17, -25, -22, 0, -1, -12, -17, -22, -24});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-18, -26, -23, 0, -1, -13, -18, -23, -25});
        EXPECTED_SELL_INS_FOR_30_DAYS.add(new int[]{-19, -27, -24, 0, -1, -14, -19, -24, -26});


        EXPECTED_QUALITIES_FOR_30_DAYS = new ArrayList<>();
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{20, 0, 7, 80, 80, 20, 49, 49, 6});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{19, 1, 6, 80, 80, 21, 50, 50, 5});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{18, 2, 5, 80, 80, 22, 50, 50, 4});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{17, 4, 4, 80, 80, 23, 50, 50, 3});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{16, 6, 3, 80, 80, 24, 50, 50, 1});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{15, 8, 2, 80, 80, 25, 50, 50, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{14, 10, 0, 80, 80, 27, 50, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{13, 12, 0, 80, 80, 29, 50, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{12, 14, 0, 80, 80, 31, 50, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{11, 16, 0, 80, 80, 33, 50, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{10, 18, 0, 80, 80, 35, 50, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{8, 20, 0, 80, 80, 38, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{6, 22, 0, 80, 80, 41, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{4, 24, 0, 80, 80, 44, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{2, 26, 0, 80, 80, 47, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 28, 0, 80, 80, 50, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 30, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 32, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 34, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 36, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 38, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 40, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 42, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 44, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 46, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 48, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 50, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 50, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 50, 0, 80, 80, 0, 0, 0, 0});
        EXPECTED_QUALITIES_FOR_30_DAYS.add(new int[]{0, 50, 0, 80, 80, 0, 0, 0, 0});
    }

    @Before
    public void setup() {

        items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        app = new GildedRose(items);
    }

    @Test
    public void testUpdateQualityFor30Days() {
        int totalNrOfDays = 30;

        for (int day = 0; day < totalNrOfDays; day++) {

            int expectedItemIndex = 0;
            for (Item item : items) {
                Assert.assertEquals(EXPECTED_SELL_INS_FOR_30_DAYS.get(day)[expectedItemIndex], item.sellIn);
                Assert.assertEquals(EXPECTED_QUALITIES_FOR_30_DAYS.get(day)[expectedItemIndex], item.quality);
                expectedItemIndex++;
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
