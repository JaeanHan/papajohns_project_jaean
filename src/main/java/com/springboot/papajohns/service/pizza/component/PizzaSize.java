package com.springboot.papajohns.service.pizza.component;

public enum PizzaSize {
    Regular(0), Large(1), FAMILY(2), PARTY(3);

    private final int value;
    PizzaSize(int value) {this.value = value;}
    int getValue() {return value;}
}
