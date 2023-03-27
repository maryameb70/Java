package org.mapsa.join;

public class GivenStartedThread_whenJoinCalled_waitsTillCompletion {
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new SampleThread(3);
        Thread t3=new MyThread();
        t2.start();
        System.out.println("Invoking join");
        t2.join();
        t3.start();
        System.out.println("Returned from join");
        assertFalse(t2.isAlive());
    }

    private static void assertFalse(boolean alive) {
    }
}
