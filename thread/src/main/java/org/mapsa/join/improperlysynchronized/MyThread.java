package org.mapsa.join.improperlysynchronized;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello");
        System.out.println("by");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread currentThread=Thread.currentThread();
        System.out.println("thread id:"+currentThread.getId());
        System.out.println("thread name:"+currentThread.getName());
    }
}
