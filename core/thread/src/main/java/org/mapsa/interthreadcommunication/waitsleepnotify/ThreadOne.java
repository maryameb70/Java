package org.mapsa.interthreadcommunication.waitsleepnotify;

public class ThreadOne implements Runnable {
    private Message msg;

    public ThreadOne(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            System.out.println(name + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
