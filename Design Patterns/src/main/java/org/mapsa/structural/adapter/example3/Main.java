package org.mapsa.structural.adapter.example3;

public class Main {
    public static void main(String[] args) {
        Shape rectangle=new Rectangle(2,3);
        ShapeAdaptor rectangleAdaptor=new ShapeAdaptorImpl(rectangle);
        System.out.println(rectangleAdaptor.getArea());
    }
}
