package org.mapsa.cretional.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton instance=Singleton.getInstance();
        instance.doSomething();

        Singleton2 singleton2=Singleton2.INSTANCE;
        singleton2.doSomething();
    }
}