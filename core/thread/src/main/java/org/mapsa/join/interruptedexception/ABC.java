package org.mapsa.join.interruptedexception;

public class ABC extends Thread{
    Thread threadToInterrupt;

    @Override
    public void run() {
        // invoking the method interrupt
        threadToInterrupt.interrupt();
    }
}
