package org.mapsa.structural.adapter.shape;

public class Square implements Shape {
    private Integer width;

    public Square(Integer width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*width;
    }
}
