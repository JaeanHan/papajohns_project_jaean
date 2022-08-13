package com.springboot.papajohns.domain.pizza;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PizzaEntity {
    private String pizza_name;
    private int pizza_size;
    private int pizza_price;

    private String crust_type;
    private int crust_price;

    private List<ToppingEntity> toppingEntities;
}
