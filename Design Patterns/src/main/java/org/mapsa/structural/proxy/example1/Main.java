package org.mapsa.structural.proxy.example1;

public class Main {
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
