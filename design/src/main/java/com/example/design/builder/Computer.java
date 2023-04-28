package com.example.design.builder;

public class Computer {
    private String hd;
    private String sd;
    private Boolean isBloutoth;
    private Boolean isGraphic;

    public String getHd() {
        return hd;
    }

    public String getSd() {
        return sd;
    }

    public Boolean getBloutoth() {
        return isBloutoth;
    }

    public Boolean getGraphic() {
        return isGraphic;
    }

    private Computer(ComputerBuilder builder){
        this.hd=builder.hd;
        this.sd=builder.sd;
        this.isBloutoth = builder.isBloutoth;
        this.isGraphic = builder.isGraphic;
    }

    public static class ComputerBuilder{
        private String hd;
        private String sd;
        private Boolean isBloutoth;
        private Boolean isGraphic;


        public ComputerBuilder(String hd, String sd) {
            this.hd = hd;
            this.sd = sd;
        }

        public ComputerBuilder setBloutoth(Boolean bloutoth) {
            this.isBloutoth = bloutoth;
            return this;
        }

        public ComputerBuilder setGraphic(Boolean graphic) {
            this.isGraphic = graphic;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
