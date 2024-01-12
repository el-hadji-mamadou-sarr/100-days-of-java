package com.designPatterns.abstractFactory;

public class VictorianTable implements Table {
    @Override
    public void assemble() {
        System.out.println("assembling victorian table");
    }
}
