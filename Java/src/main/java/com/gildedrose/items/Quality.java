package com.gildedrose.items;

/**
 * The quality of an item.
 *
 * The value of the quality is bounded between 0 and 50 (inclusive). When trying to create a quality with a value outside
 * of these boundaries, the value will be automatically set to 0 (if given value was below 0) or 50 (if given value was above 50).
 *
 * Quality instances are immutable.
 *
 */
public class Quality {

    public static final int MIN_VALUE=0;

    public static final int MAX_VALUE=50;

    private int value;

    private Quality(final int value) {
        this.value = value;
    }

    public static Quality create(final int value) {
        return new Quality(value);
    }

    public int value() {
        return value;
    }

    public Quality increase(int increaseValue) {
        int newValue = value + increaseValue;
        if(newValue > MAX_VALUE) {
            return create(MAX_VALUE);
        }
        return create(newValue);
    }

    public Quality decrease(int decreaseValue) {
        int newValue = value - decreaseValue;
        if(newValue < MIN_VALUE) {
            return create(MIN_VALUE);
        }
        return create(newValue);
    }
}
