package org.mapsa.join.withjoin;

public class ThreadJoin extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(300);
                System.out.println("The current thread name is: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException("The exception has been caught:" + e);
            }
            System.out.println( i );
        }
    }
}
