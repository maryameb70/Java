package org.mapsa.runnable;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("salam");
        Thread th=new Thread(new MyRunnable());
        th.start();
        System.out.println("khodahafez");

    }
}
