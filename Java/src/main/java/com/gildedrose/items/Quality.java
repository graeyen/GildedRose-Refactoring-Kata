package com.gildedrose.items;

public class Quality {

    public static final int MIN_VALUE=0;

    public static final int MAX_VALUE=50;

    private int value;

    private Quality(int value) {
        this.value = value;
    }

    public static Quality create(int value) {
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
