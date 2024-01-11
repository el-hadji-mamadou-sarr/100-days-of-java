package com.designPatterns.factoryMethod;

import com.designPatterns.factoryMethod.Burger;

public class BeefBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("preparing beef burger");
    }

    @Override
    public String toString() {
        return "beef burger";
    }
}
