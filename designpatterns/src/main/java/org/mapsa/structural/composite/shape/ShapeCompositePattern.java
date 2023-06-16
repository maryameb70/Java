package org.mapsa.structural.composite.shape;

public class ShapeCompositePattern {
    public static void main(String[] args) {
        Shape triangle=new Triangle();
        Shape circle=new Circle();
        Drawing drawing=new Drawing();
        drawing.add(triangle);
        drawing.add(circle);
        drawing.draw("Pink");
        drawing.clear();

        drawing.add(triangle);
        drawing.remove(triangle);
        drawing.add(circle);
        drawing.draw("Red");
    }
}
