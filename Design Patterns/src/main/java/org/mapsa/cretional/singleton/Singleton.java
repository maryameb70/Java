package org.mapsa.cretional.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {   //har tread vared nashe
            synchronized (Singleton.class) {  //treadSafe bashe
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void doSomething(){
        System.out.println("Something");
    }
}
