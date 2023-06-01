package org.mapsa.structural.adapter.example3;

public class ShapeAdaptorImpl implements ShapeAdaptor {
    private Shape shape;

    public ShapeAdaptorImpl(Shape shape) {
        this.shape = shape;
    }

    @Override
    public double getArea() {
        double areaMetr=shape.getArea();
        return convertMETRtoCM(areaMetr);
    }

    private double convertMETRtoCM(double metr){
        return metr*100;
    }

}
