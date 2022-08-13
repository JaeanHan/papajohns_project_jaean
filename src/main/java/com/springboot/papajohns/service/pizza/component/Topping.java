package com.springboot.papajohns.service.pizza.component;

import com.springboot.papajohns.domain.pizza.ToppingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topping {
    private String toppingType;
    private String toppingName;
    private int toppingPrice;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    public ToppingEntity toEntity() {
        return ToppingEntity.builder()
                .topping_name(toppingName)
                .build();
    }
}
