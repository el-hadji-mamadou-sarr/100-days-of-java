package com.designPatterns.factoryMethod;

import com.designPatterns.factoryMethod.Burger;

/*
 * this design pattern is to create objects in the super class but allows the subclasses
 * to modify the type of object we want to create
 * 
 * So the problem is that the subclass may return different type
 * Solution: create a common based class or interface
 */
abstract class Restaurant {
    public Burger orderBurger() {
        Burger burger = null;
        burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}
