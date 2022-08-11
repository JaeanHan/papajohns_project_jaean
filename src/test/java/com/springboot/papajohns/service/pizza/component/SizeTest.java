package com.springboot.papajohns.service.pizza.component;

import org.junit.jupiter.api.Test;

import static com.springboot.papajohns.service.pizza.component.PizzaSize.Large;

class SizeTest {

    @Test
    void values() {
        System.out.println(Large.getValue());
    }

    @Test
    void valueOf() {
    }
}