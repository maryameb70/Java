package org.mapsa.cretional.builder;

public class Computer {
    private String hdd;
    private String ram;
    private Boolean isGraphicsCardEnabled;
    private Boolean isBluetoothEnabled;

    public String getHdd() {
        return hdd;
    }

    public String getRam() {
        return ram;
    }

    public Boolean getGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public Boolean getBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder builder) {
        this.hdd = builder.HDD;
        this.ram =builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static class ComputerBuilder{
        private String HDD;
        private String RAM;
        private Boolean isGraphicsCardEnabled;
        private Boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicsCardEnabled(Boolean graphicsCardEnabled) {
            this.isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(Boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

}

