package com.example.design.singletone;

public class Main {
    public static void main(String[] args) {
       SingleTone singleTone= SingleTone.getInstance();
       singleTone.print();

       SingleTone2 singleTone2=SingleTone2.INSTANCE;
       singleTone2.print();
    }
}
