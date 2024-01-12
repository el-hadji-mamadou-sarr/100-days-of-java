package com.designPatterns.abstractFactory;

public class VictorianChair implements Chair {

    @Override
    public void assemble() {
        System.out.println("assembling victorian chair");
    }
}
