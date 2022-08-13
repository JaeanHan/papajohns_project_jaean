package com.springboot.papajohns.service.pizza;

import com.springboot.papajohns.domain.pizza.PizzaEntity;
import com.springboot.papajohns.domain.pizza.ToppingEntity;
import com.springboot.papajohns.service.pizza.component.Crust;
import com.springboot.papajohns.service.pizza.component.PizzaMenu;
import com.springboot.papajohns.service.pizza.component.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PizzaDto {
    private final PizzaMenu pizzaMenu;
    private Crust crust;
    private List<Topping> toppings;

    public PizzaDto(PizzaMenu pizzaMenu, Crust crust) {
        this.pizzaMenu = pizzaMenu;
        this.crust = crust;
    }

    public PizzaDto(PizzaMenu pizzaMenu, List<Topping> toppings) {
        this.pizzaMenu = pizzaMenu;
        this.toppings = toppings;
    }

    public int getTotalPrice() {
        int totalPrice = pizzaMenu.getPizzaPrice();

        if(crust != null) {
            totalPrice += crust.getCrustPrice();
        }

        if(toppings != null) {
            totalPrice += toppings.stream().mapToInt(Topping::getToppingPrice).sum();
        }
        return totalPrice;
    }

    public PizzaEntity toEntity() {
        if(crust == null && toppings == null)
            return PizzaEntity.builder()
                    .pizza_name(pizzaMenu.getPizzaName())
                    .pizza_size(pizzaMenu.getPizzaSize())
                    .build();

        List<ToppingEntity> toppingEntities = new ArrayList<>();

        if(toppings != null) {
            toppings.forEach(topping -> {toppingEntities.add(topping.toEntity());});
        }

        if(crust == null)
            return PizzaEntity.builder()
                    .pizza_name(pizzaMenu.getPizzaName())
                    .pizza_size(pizzaMenu.getPizzaSize())
                    .toppingEntities(toppings == null? null : toppingEntities)
                    .build();

        return PizzaEntity.builder()
            .pizza_name(pizzaMenu.getPizzaName())
            .pizza_size(pizzaMenu.getPizzaSize())
            .crust_type(crust.getCrustType())
            .toppingEntities(toppings == null? null : toppingEntities)
            .build();
    }
}
