package com.example.demo;

public class SingleTone {
    private static SingleTone instance;
    private SingleTone(){

    }
    public static SingleTone getInstance(){
        if(instance==null){
            synchronized (SingleTone.class){
                if(instance==null){
                   instance=new SingleTone();
                }
            }
        }
        return instance;
    }
}
