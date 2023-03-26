package org.mapsa.cretional.builder;

public class Main {
    public static void main(String[] args) {
        Computer build=new Computer.ComputerBuilder("maxtor","King")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(false).build();
    }
}
