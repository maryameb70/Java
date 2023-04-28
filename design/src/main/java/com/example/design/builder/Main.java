package com.example.design.builder;

public class Main {
    public static void main(String[] args) {
       Computer computer=new Computer.ComputerBuilder("h","s")
               .setBloutoth(true)
               .setGraphic(false)
               .build();
    }
}
