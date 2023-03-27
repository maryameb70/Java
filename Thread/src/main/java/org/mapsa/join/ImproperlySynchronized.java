package org.mapsa.join;

public class ImproperlySynchronized {
    public static void main(String[] args) throws InterruptedException {
        SampleThread t4 = new SampleThread(10);
        t4.start();
// not guaranteed to stop even if t4 finishes.
        do {
            //t4.join();
        } while (t4.processingCount > 0);
    }

}
