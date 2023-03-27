package org.example.shape;

public class Rectangle extends Shape {
    private Double width;
    private Double length;

    public Rectangle() {
        this.width = 1.0d;
        this.length = 1.0d;
    }

    public Rectangle(Double width, Double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, Boolean filled, Double width, Double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    @Override
    public Double getArea(){
        return this.width == this.length ? this.width * this.width : this.width * this.length;
    }

    @Override
    public Double getPerimeter() {
        return this.width == this.length ? 4 * this.width : 2 * (this.width + this.length);
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + this.width + "and with length" + this.length + ", which is a subclass of " + super.toString();
    }


}
