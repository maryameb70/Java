package org.mapsa.cretional.factorymethod.shape;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape shape1=ShapeFactory.getShape(ShapeType.CIRCLE);
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = ShapeFactory.getShape(ShapeType.RECTANGLE);
        shape2.draw();
    }
}
