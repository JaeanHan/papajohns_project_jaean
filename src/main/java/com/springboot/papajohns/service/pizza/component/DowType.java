package com.springboot.papajohns.service.pizza.component;

public enum DowType {
    ORIGINAL(0), THIN(1), CHEESE_BALL(2), GOLDEN_RING(3);
    private final int value;
    DowType(int value) {this.value = value;}

    int getValue() {return value;}
}
