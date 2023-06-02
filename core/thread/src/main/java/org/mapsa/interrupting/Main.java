package org.mapsa.interrupting;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Interrupted t = new Interrupted();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
