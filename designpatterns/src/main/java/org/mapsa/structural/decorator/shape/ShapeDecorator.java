package org.mapsa.structural.decorator.shape;

public abstract class ShapeDecorator implements Shape {
   // has a HAS-A relationship with the component interface
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }


}
