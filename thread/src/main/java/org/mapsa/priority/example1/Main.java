package org.mapsa.priority.example1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new ThreadRunnable());
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        ThreadExtend t2=new ThreadExtend();
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.join();
        t2.start();
    }
}
