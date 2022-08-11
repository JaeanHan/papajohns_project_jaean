package com.springboot.papajohns.domain.pizza;

import com.springboot.papajohns.service.pizza.PizzaDto;
import com.springboot.papajohns.service.pizza.component.Dow;
import com.springboot.papajohns.service.pizza.component.PizzaMenu;
import com.springboot.papajohns.service.pizza.component.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PizzaTest {
    PizzaMenu menu = new PizzaMenu() {
        public int getPizzaPrice() {
            return 28000;
        }
    };
    Dow dow = new Dow() {
        public int getDowPrice() {
            return 4000;
        }
    };
    Topping toping = new Topping() {
        public int getTopingPrice() {
            return 1500;
        }
    };

    List<Topping> topings = new ArrayList<>();

    @BeforeEach
    public void addTopingToTopings() {
        topings.clear();
        topings.add(toping);

        PizzaDto pizza = new PizzaDto(menu, dow, topings);
    }

    int getAllToping() {
        return topings.stream().mapToInt(Topping::getTopping_price).sum();
    }
    @DisplayName("Optional 연습")
    @Test
    void optional() {
        // pizza price 28000
        int totalPrice = menu.getPizza_price();

        // dow price 4000
        totalPrice += Optional.ofNullable(dow).map(Dow::getDow_price).orElse(0);

        // toping price 하는중
    }
}