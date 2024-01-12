package com.dsa;

import com.designPatterns.abstractFactory.Chair;
import com.designPatterns.abstractFactory.VictorianFactory;
import com.designPatterns.factoryMethod.BeefBurgerRestaurant;
import com.designPatterns.factoryMethod.Burger;

public class Main {

    public static void main(String[] args) {
        VictorianFactory victorianFactory = new VictorianFactory();
        Chair victorianChair = victorianFactory.createChair();
        

    }
}