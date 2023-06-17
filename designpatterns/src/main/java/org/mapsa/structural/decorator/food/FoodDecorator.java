package org.mapsa.structural.decorator.food;

public abstract class FoodDecorator implements Food {
    protected Food newFood;

    public FoodDecorator(Food newFood) {
        this.newFood = newFood;
    }

    @Override
    public String prepareFood() {
        return newFood.prepareFood();
    }

    @Override
    public double foodPrice() {
        return newFood.foodPrice();
    }
}
