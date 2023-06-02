package org.mapsa.interrupting;

public class Interrupted extends Thread{
    @Override
    public synchronized void run() {
        try {
            wait();
            System.out.println("After Wait");
        } catch (InterruptedException e) {
            System.out.println("Interrupter");
        }
        System.out.println("Resume");
    }
}
