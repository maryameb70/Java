package org.mapsa.interrupting.doesntstopworking;

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

    public static void main(String[] args) throws InterruptedException {
        Interrupted t = new Interrupted();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
