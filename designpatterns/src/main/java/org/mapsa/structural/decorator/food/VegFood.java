package org.mapsa.structural.decorator.food;

public class VegFood implements Food {
    @Override
    public String prepareFood() {
        return "Veg Food";
    }

    @Override
    public double foodPrice() {
        return 50.0;
    }
}
