package com.springboot.papajohns.service.pizza.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaMenu {
    private String pizzaName;
    private int pizzaSize;
    private int pizzaPrice;

    public PizzaMenu(String pizzaName, int pizzaSize) {
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;
    }

}
