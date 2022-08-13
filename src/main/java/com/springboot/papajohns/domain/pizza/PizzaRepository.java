package com.springboot.papajohns.domain.pizza;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PizzaRepository {
    public int getPizzaTotalPriceOfOne1(PizzaEntity pizzaEntity) throws Exception;
    public int getPizzaTotalPriceOfOne2(PizzaEntity pizzaEntity) throws Exception;

//    public PizzaEntity getPizzaOnBoard(PizzaEntity pizzaEntity);
}
