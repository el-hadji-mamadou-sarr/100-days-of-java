package com.dsa;

import com.designPatterns.factoryMethod.BeefBurgerRestaurant;
import com.designPatterns.factoryMethod.Burger;

public class Main {

    public static void main(String[] args) {
        BeefBurgerRestaurant beefResto = new BeefBurgerRestaurant();
        Burger burger = beefResto.orderBurger();
        System.out.println(burger.toString());

    }
}