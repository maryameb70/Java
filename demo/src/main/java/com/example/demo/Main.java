package com.example.demo;

public class Main {
    public static void main(String[] args) {
        SingleTone singleTone = SingleTone.getInstance();
        SingleTone2 singleTone2=SingleTone2.INSTANCE;
    }
}
