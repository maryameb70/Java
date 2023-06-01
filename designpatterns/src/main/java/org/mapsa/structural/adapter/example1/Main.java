package org.mapsa.structural.adapter.example1;

public class Main {
    public static void main(String[] args) {
        Movable benz=new Benz();
        MovableAdaptor benzAdaptor=new MovableAdaptorImpl(benz);
        System.out.println("benz top speed:"+benzAdaptor.convertSpeed());

        Movable samand=new Samand();
        MovableAdaptor samandAdaptor = new MovableAdaptorImpl(samand);
        System.out.println("samand top speed:"+samandAdaptor.convertSpeed());

        Movable maxima = new Maxima();
        MovableAdaptor maximaAdaptor = new MovableAdaptorImpl(maxima);
        System.out.println("maxima top speed:"+maximaAdaptor.convertSpeed());

    }
}
