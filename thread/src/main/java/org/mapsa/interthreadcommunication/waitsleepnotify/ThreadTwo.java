package org.mapsa.interthreadcommunication.waitsleepnotify;

public class ThreadTwo implements Runnable {
    private Message msg;

    public ThreadTwo(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name+" started");
                msg.wait();
                System.out.println(name+" finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
