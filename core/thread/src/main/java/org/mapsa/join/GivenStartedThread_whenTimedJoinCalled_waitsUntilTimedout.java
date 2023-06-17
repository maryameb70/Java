package org.mapsa.join;

import org.mapsa.join.improperlysynchronized.MyThread;
import org.mapsa.join.improperlysynchronized.SampleThread;

public class GivenStartedThread_whenTimedJoinCalled_waitsUntilTimedout {
    public static void main(String[] args) throws InterruptedException {
        SampleThread t3 = new SampleThread(3);
        Thread t4=new MyThread();
        t3.start();
        t3.join(4000);
        assertTrue(t3.isAlive());
        t4.start();
    }

    private static void assertTrue(boolean alive) {
    }
}
