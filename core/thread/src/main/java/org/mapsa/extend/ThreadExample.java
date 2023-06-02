package org.mapsa.extend;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("salam");
        Thread th=new MyThread();
        th.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("khodahafez");
        Thread currentThread=Thread.currentThread();
        System.out.println("thread id:"+currentThread.getId());
        System.out.println("thread name:"+currentThread.getName());
    }
}
