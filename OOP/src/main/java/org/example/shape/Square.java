package org.example.shape;

public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(Double width, Double length)throws InvalidInputException {
        super(width, length);
        if (!statesEquality()) {
            throw new InvalidInputException();
        }
    }

    public Square(String color, Boolean filled, Double width, Double length) throws InvalidInputException {
        super(color, filled, width, length);
        if (!statesEquality()) {
            throw new InvalidInputException();
        }
    }

    private boolean statesEquality() {
        return super.getWidth() == super.getLength();
    }

    @Override
    public Double getArea() {
        return super.getArea();
    }

    @Override
    public Double getPerimeter() {
        return super.getPerimeter();
    }
}
