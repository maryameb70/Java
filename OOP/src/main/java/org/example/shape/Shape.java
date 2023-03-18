package org.example.shape;

public abstract class Shape {
    private String color;
    private Boolean filled;

    public Shape() {
        color = "green";
        filled = true;
    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String checkFilled = isFilled() ? "filled" : "Not filled";
        return "A shape with color of " + this.color + " And " + checkFilled;
    }

    public abstract Double getArea();

    public abstract Double getPerimeter() ;
}
