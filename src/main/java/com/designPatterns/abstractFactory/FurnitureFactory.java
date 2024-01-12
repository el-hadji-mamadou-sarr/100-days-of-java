package com.designPatterns.abstractFactory;

public abstract class FurnitureFactory {

    public abstract Chair createChair();

    public abstract Sofa createSofa();

    public abstract Table createTable();
}
