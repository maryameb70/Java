package org.mapsa.join.interruptedexception;

public class ThreadJoinExample1 {
    public static void main(String[] args) {
        try {
        // creating an object of the class ABC
            ABC th1 = new ABC();
            th1.threadToInterrupt = Thread.currentThread();
            th1.start();

        // invoking the join() method leads
        // to the generation of InterruptedException
            th1.join();
        } catch (InterruptedException ex) {
            System.out.println("The exception has been caught. " + ex);
        }
    }
}

