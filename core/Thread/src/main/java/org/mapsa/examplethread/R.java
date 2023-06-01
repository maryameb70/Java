package org.mapsa.examplethread;

public class R implements Runnable{
    @Override
    public void run() {
        for (char c = 'A'; c < 'Z'; c++) {
            System.out.println(c);
        }
    }
}
