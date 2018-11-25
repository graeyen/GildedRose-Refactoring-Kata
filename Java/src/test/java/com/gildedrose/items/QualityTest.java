package com.gildedrose.items;

import static com.gildedrose.items.Quality.MAX_VALUE;
import static com.gildedrose.items.Quality.MIN_VALUE;
import static org.junit.Assert.*;

import org.junit.Test;

public class QualityTest {

    @Test
    public void testIncrease() {
        int value = 10;
        int increaseValue = 5;

        int result = Quality.create(value).increase(increaseValue).value();
        assertEquals(15, result);
    }

    @Test
    public void testIncreaseToMax() {
        int value = 45;
        int increaseValue = 5;

        int result = Quality.create(value).increase(increaseValue).value();
        assertEquals(MAX_VALUE, result);
    }

    @Test
    public void testIncreaseAfterMax() {
        int value = MAX_VALUE;
        int increaseValue = MAX_VALUE+1;

        int result = Quality.create(value).increase(increaseValue).value();
        assertEquals(MAX_VALUE, result);
    }

    @Test
    public void testDecrease() {
        int value = 10;
        int decreaseValue = 5;

        int result = Quality.create(value).decrease(decreaseValue).value();
        assertEquals(5, result);
    }

    @Test
    public void testDecreaseToMin() {
        int value = 10;
        int decreaseValue = value;

        int result = Quality.create(value).decrease(decreaseValue).value();
        assertEquals(MIN_VALUE, result);
    }

    @Test
    public void testDecreaseBelowMin() {
        int value = 10;
        int decreaseValue = value+1;

        int result = Quality.create(value).decrease(decreaseValue).value();
        assertEquals(MIN_VALUE, result);
    }

}