package org.mapsa.structural.adapter.car;

public class MovableAdaptorImpl implements MovableAdaptor {
    private Movable luxuryCars;

    public MovableAdaptorImpl(Movable luxuryCars) {
        this.luxuryCars = luxuryCars;
    }

    @Override
    public double convertSpeed() {
        double mbh=luxuryCars.getSpeed();
        return convertMPHtoKMPH(mbh);
    }
    private double convertMPHtoKMPH(double mph){
        return mph*1.60934;
    }

}
