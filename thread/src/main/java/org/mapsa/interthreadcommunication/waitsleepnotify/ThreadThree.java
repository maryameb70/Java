package org.mapsa.interthreadcommunication.waitsleepnotify;

public class ThreadThree implements Runnable {
    private Message msg;

    public ThreadThree(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        synchronized (msg) {
            msg.notify();
            System.out.println(name+" finished");
        }
    }
}
