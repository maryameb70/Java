package org.mapsa.priority.example1;

public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End");
    }
}
