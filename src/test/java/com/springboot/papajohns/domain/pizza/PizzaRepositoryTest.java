package com.springboot.papajohns.domain.pizza;

import com.springboot.papajohns.service.pizza.PizzaDto;
import com.springboot.papajohns.service.pizza.component.Crust;
import com.springboot.papajohns.service.pizza.component.PizzaMenu;
import com.springboot.papajohns.service.pizza.component.Topping;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PizzaRepositoryTest {
    @Autowired
    private PizzaRepository pizzaRepository;
    private PizzaDto pizzaDto;
    private PizzaEntity pizzaEntity;

    @BeforeEach
    void initPizza() {
        PizzaMenu pizzaMenu = new PizzaMenu("올미트", 1);
        Crust crust = new Crust("골드링");
        Topping topping1 = new Topping("감자");
        Topping topping2 = new Topping("햄");

        List<Topping> toppings = new ArrayList<>();
        toppings.add(topping1);
        toppings.add(topping2);

        pizzaDto = new PizzaDto(pizzaMenu, crust, toppings);
        System.out.println(pizzaDto.getTotalPrice());
        pizzaEntity = pizzaDto.toEntity();
    }

    @DisplayName("4. Dynamic query Test")
    @Test
    void queryTest() throws Exception {
        int result;
        result = pizzaRepository.getPizzaTotalPriceOfOne1(pizzaEntity);

        Assertions.assertEquals(result, 36500);
    }

    @DisplayName("5. Dynamic query speed test")
    @Test
    void QueryTest2() throws Exception {
        int result;
        result = pizzaRepository.getPizzaTotalPriceOfOne2(pizzaEntity);

        Assertions.assertEquals(result, 36500);
    }


//    @DisplayName("1. 보통 피자 가격 가져오기")
//    @Test
//    void getPizzaPrice() throws Exception {
//        PizzaMenu pizzaMenu = new PizzaMenu("수퍼 파파스", 0);
//        PizzaDto pizzaDto1 = new PizzaDto(pizzaMenu);
//
//        int result;
//        result = pizzaRepository.getPizzaPrice(pizzaDto1.toEntity());
//
//        Assertions.assertEquals(result, 19900);
//    }
//
//    @DisplayName("2. 피자 크러스트 추가한 가격 가져오기")
//    @Test
//    void getPizzaWithCrustPrice() throws Exception {
//        PizzaMenu pizzaMenu = new PizzaMenu("수퍼 파파스", 1);
//        Crust crust = new Crust("치즈롤");
//        PizzaDto pizzaDto = new PizzaDto(pizzaMenu, crust);
//        int result;
//        result = pizzaRepository.getPizzaWithCrustPrice(pizzaDto.toEntity());
//
//        Assertions.assertEquals(result, 32500);
//    }
//
//    @DisplayName("3. 토핑 추가만하기")
//    @Test
//    void getToppingPrice() throws Exception {
////        service
//        Topping topping1 = new Topping("베이컨");
//        Topping topping2 = new Topping("체다 치즈");
//        Topping topping3 = new Topping("양파");
//        Topping topping4 = new Topping("감자");
//
//        List<Topping> toppings = new ArrayList<>();
//        toppings.add(topping1);
//        toppings.add(topping2);
//        toppings.add(topping3);
//        toppings.add(topping4);
//
//        List<ToppingEntity> entities = new ArrayList<>();
//        toppings.forEach(t -> {entities.add(t.toEntity());});
//
////        domain
//        List<Integer> result;
//
//        result = pizzaRepository.getToppingPrice(entities);
//
//        Assertions.assertEquals(result.stream().mapToInt(t -> t.intValue()).sum(), 6000);
//    }

}
