package com.springboot.papajohns.service.pizza.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Crust {
    private final String crustType;
    private int crustPrice;

}
