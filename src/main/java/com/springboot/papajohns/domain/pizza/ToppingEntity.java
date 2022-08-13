package com.springboot.papajohns.domain.pizza;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToppingEntity {
    private String topping_type;
    private String topping_name;
    private int topping_price;
}
