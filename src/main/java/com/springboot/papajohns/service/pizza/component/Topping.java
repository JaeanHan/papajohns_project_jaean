package com.springboot.papajohns.service.pizza.component;

import lombok.Data;

@Data
public class Topping {
    private String topping_type;
    private String topping_name;
    private int topping_price;
}
