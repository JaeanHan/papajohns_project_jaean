package com.springboot.papajohns.service.pizza;

import com.springboot.papajohns.service.pizza.component.Dow;
import com.springboot.papajohns.service.pizza.component.PizzaMenu;
import com.springboot.papajohns.service.pizza.component.Topping;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
public class PizzaDto {
    private final PizzaMenu pizzaMenu;
    private Dow dow;
    private List<Topping> toppings;

    public PizzaDto(PizzaMenu pizzaMenu, Dow dow) {
        this.pizzaMenu = pizzaMenu;
        this.dow = dow;
    }

    public PizzaDto(PizzaMenu pizzaMenu, List<Topping> toppings) {
        this.pizzaMenu = pizzaMenu;
        this.toppings = toppings;
    }

    public int getTotalPrice() {
        int totalPrice = pizzaMenu.getPizza_price();

        if(dow != null) {
            totalPrice += dow.getDow_price();
        }

        if(toppings != null) {
            totalPrice += toppings.stream().mapToInt(Topping::getTopping_price).sum();
        }
        return totalPrice;
    }
}
